/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the So Аftware without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLEntryGameweek;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLGameweek;
import com.github.jamoamo.jfpl.model.FPLPlayerType;
import com.github.jamoamo.jfpl.model.FPLTeam;
import com.github.jamoamo.jfpl.model.FPLUser;
import com.github.jamoamo.jfpl.model.FPLUserHistory;
import com.github.jamoamo.jfpl.model.FPLUserTeam;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Starting point for accessing the unofficial FPL API.
 */
@SuppressWarnings("checkstyle:classFanOutComplexity")
public final class FPL
{

	private final IFPLClient fplClient;
	private final FPLDataCache cachedData = new FPLDataCache();

	/**
	 * Create a connection to FPL without logging in. Certain functionality will not be available.
	 */
	public FPL()
	{
		this(new FPLClient());
	}

	FPL(final IFPLClient client)
	{
		this.fplClient = client;
	}

	/**
	 * Login to FPL with the provided FPL credentials.
	 *
	 * @param creds The FPLLoginCredentials object containing the username and password
	 *
	 * @throws XFPLLoginException if something went wrong during authentication
	 */
	public void login(final FPLLoginCredentials creds)
			  throws XFPLLoginException
	{
		boolean loginSuccess = false;
		try
		{
			loginSuccess = this.fplClient.login(creds);
		}
		catch(XClientException ex)
		{
			throw new XFPLLoginException(ex);
		}

		if(!loginSuccess)
		{
			throw new XFPLLoginException();
		}
	}

	/**
	 * Indicates if the client is logged into FPL.
	 *
	 * @return {@code true} if logged in else {@code false}
	 */
	public boolean isLoggedIn()
	{
		return this.fplClient.isLoggedIn();
	}

	/**
	 * Returns the current user. Requires that the user be logged in using the
	 * {@link FPL#login(com.github.jamoamo.jfpl.FPLLoginCredentials)} method
	 *
	 * @return an object representing the current logged in user
	 *
	 * @throws Exception if an error occurs
	 * @see FPL#login(com.github.jamoamo.jfpl.FPLLoginCredentials)
	 */
	public FPLUser getCurrentUser()
			  throws Exception
	{
		JsonCurrentUser current = getCurrentUserData();
		if(current == null)
		{
			return null;
		}
		JsonUser user = this.fplClient.getUser(current.getPlayer().getEntry());

		UserMapper userMapper = new UserMapper();
		return userMapper.mapUser(user, getTeamMap());
	}

	private JsonCurrentUser getCurrentUserData()
			  throws IOException
	{
		JsonCurrentUser current = null;
		if(this.cachedData != null && this.cachedData.getCurrentUser() != null)
		{
			current = this.cachedData.getCurrentUser();
		}

		if(current == null)
		{
			current = this.fplClient.getCurrentUser();
			cachedData.storeCurrentUser(current);
		}
		return current;
	}

	/**
	 * @return the team of the current logged-in user
	 *
	 * @throws Exception if an error occurs
	 */
	public FPLUserTeam getCurrentUserTeam()
			  throws Exception
	{
		JsonCurrentUser current = getCurrentUserData();
		if(current == null)
		{
			return null;
		}
		JsonCurrentUserTeam team = this.fplClient.getCurrentUserTeam(current.getPlayer().getEntry());

		UserTeamMapper mapper = new UserTeamMapper();
		return mapper.mapUserTeam(team, getPlayerMap());
	}

	/**
	 * @return a full list of players in FPL
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public List<FPLPlayer> getPlayers()
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		JsonStaticData data = getStaticData();
		List<JsonPlayer> fplplayers = data.getElements();
		PlayerMapper mapper = new PlayerMapper();
		List<FPLPlayer> players =
				  fplplayers.stream()
							 .map(p -> mapper.mapPlayer(p, this.getTeamMap()))
							 .collect(Collectors.toList());
		return players;
	}

	/**
	 * Get the current FPL game-week. returns NULL if there is no current game-week.
	 *
	 * @return
	 *         the game-week of the current FPL game-week.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public FPLGameweek getCurrentGameweek()
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		return getGameweeks().stream().filter(g -> g.isCurrent()).findFirst().orElse(null);
	}

	/**
	 * @return a list of all FPL game-weeks.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public List<FPLGameweek> getGameweeks()
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		JsonStaticData data = getStaticData();
		final GameweekMapper mapper = new GameweekMapper();
		return data.getEvents()
				  .stream()
				  .map(gameweek -> mapper.mapGameweek(gameweek))
				  .collect(Collectors.toList());
	}

	/**
	 * Get a list of all fixtures.
	 *
	 * @return a list of al fixtures.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public List<FPLFixture> getFixtures()
			  throws XFPLUnavailableException
	{
		try
		{
			List<JsonFixture> fplFixtures = this.fplClient.getFixtures();
			FixtureMapper mapper = new FixtureMapper();
			List<FPLFixture> fixtures = fplFixtures
					  .stream()
					  .map(f -> mapper.mapFixture(f, getTeamMap())).collect(Collectors.toList());
			return fixtures;
		}
		catch(XConnectionException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(XResponseMappingException ex)
		{
			throw new XFPLAPIResponseException();
		}
		catch(XResourceNotFound xrnf)
		{
			throw new XFPLResourceNotFound();
		}
	}

	/**
	 * Get a list of all teams.
	 *
	 * @return a list of all teams.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public List<FPLTeam> getTeams()
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		JsonStaticData data = getStaticData();
		TeamMapper mapper = new TeamMapper();

		List<FPLTeam> teams = data
				  .getTeams()
				  .stream()
				  .map(t -> mapper.mapTeam(t))
				  .collect(Collectors.toList());
		return teams;
	}

	/**
	 * get the current user's history.
	 *
	 * @return a history of the current user
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public FPLUserHistory getCurrentUserHistory()
			  throws XFPLUnavailableException
	{
		try
		{
			JsonCurrentUser user = fplClient.getCurrentUser();

			FPLUserHistory userHistory = getUserHistory(user.getPlayer().getEntry());

			return userHistory;
		}
		catch(XConnectionException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(XResponseMappingException ex)
		{
			throw new XFPLAPIResponseException();
		}
		catch(XResourceNotFound xrnf)
		{
			throw new XFPLResourceNotFound();
		}
	}

	/**
	 * Get history of the user with the provided entry id.
	 *
	 * @param userEntryId The entry id of the user.
	 *
	 * @return a history for the provided user
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public FPLUserHistory getUserHistory(int userEntryId)
	{
		try
		{
			JsonUserHistory userHistory = fplClient.getUserHistory(userEntryId);
			UserHistoryMapper mapper = new UserHistoryMapper();
			return mapper.mapUserHistory(userHistory);
		}
		catch(XConnectionException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(XResponseMappingException ex)
		{
			throw new XFPLAPIResponseException();
		}
		catch(XResourceNotFound xrnf)
		{
			throw new XFPLResourceNotFound();
		}
	}

	/**
	 * Get the Entry game week for the provided entry and game week.
	 *
	 * @param entry    The entry.
	 * @param gameweek The game week.
	 *
	 * @return The entry game week.
	 */
	public FPLEntryGameweek getEntryGameweek(int entry, int gameweek)
	{
		try
		{
			JsonEntryGameweek entryGameweek = fplClient.getEntryGameweek(entry, gameweek);
			EntryGameweekMapper mapper = new EntryGameweekMapper();
			return mapper.mapEntryGameweek(entryGameweek, getPlayerMap());
		}
		catch(XConnectionException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(XResponseMappingException ex)
		{
			throw new XFPLAPIResponseException();
		}
		catch(XResourceNotFound xrnf)
		{
			throw new XFPLResourceNotFound();
		}
	}

	/**
	 * Get the FPL player types.
	 * 
	 * @return the list of player types.
	 */
	public List<FPLPlayerType> getPlayerTypes()
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		try
		{
			JsonStaticData data = getStaticData();
			PlayerTypeMapper mapper = new PlayerTypeMapper();

			List<FPLPlayerType> playerTypes =
					  data.getElementTypes().stream().map(elemType -> mapper.mapPlayerType(elemType))
							.collect(Collectors.toList());

			return playerTypes;
		}
		catch(XConnectionException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(XResponseMappingException ex)
		{
			throw new XFPLAPIResponseException();
		}
		catch(XResourceNotFound xrnf)
		{
			throw new XFPLResourceNotFound();
		}
	}

	private JsonStaticData getStaticData()
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		if(cachedData.getStaticData() != null)
		{
			return cachedData.getStaticData();
		}

		try
		{
			JsonStaticData data = this.fplClient.getStaticData();
			this.cachedData.storeStaticData(data);
			return data;
		}
		catch(XConnectionException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(XResponseMappingException ex)
		{
			throw new XFPLAPIResponseException();
		}
		catch(XResourceNotFound xrnf)
		{
			throw new XFPLResourceNotFound();
		}
	}

	private Map<Integer, FPLTeam> getTeamMap()
	{
		Map<Integer, FPLTeam> teams = getTeams()
				  .stream()
				  .collect(Collectors.toMap(t -> t.getId(), t -> t));
		return teams;
	}

	private Map<Integer, FPLPlayer> getPlayerMap()
	{
		Map<Integer, FPLPlayer> players = getPlayers()
				  .stream()
				  .collect(Collectors.toMap(p -> p.getId(), p -> p));
		return players;
	}
}
