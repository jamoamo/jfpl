/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
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
import com.github.jamoamo.jfpl.model.FPLGameweekPlayerStats;
import com.github.jamoamo.jfpl.model.FPLPlayerType;
import com.github.jamoamo.jfpl.model.FPLTeam;
import com.github.jamoamo.jfpl.model.FPLUser;
import com.github.jamoamo.jfpl.model.FPLUserHistory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Starting point for accessing the unofficial FPL API.
 */
// Fan-out is high because this facade owns translating every FPL JSON DTO into its public model
// counterpart via a dedicated mapper per resource type; splitting it up would just move the fan-out
// to another class rather than reduce it.
@SuppressWarnings("checkstyle:classFanOutComplexity")
public final class FPL
{
	private static final Logger LOGGER = LogManager.getLogger(FPL.class);

	private final IFPLClient fplClient;
	private final FPLDataCache cachedData = new FPLDataCache();

	private final UserMapper userMapper = new UserMapper();
	private final PlayerMapper playerMapper = new PlayerMapper();
	private final GameweekMapper gameweekMapper = new GameweekMapper();
	private final FixtureMapper fixtureMapper = new FixtureMapper();
	private final TeamMapper teamMapper = new TeamMapper();
	private final UserHistoryMapper userHistoryMapper = new UserHistoryMapper();
	private final EntryGameweekMapper entryGameweekMapper = new EntryGameweekMapper();
	private final PlayerTypeMapper playerTypeMapper = new PlayerTypeMapper();
	private final LiveGameweekMapper liveGameweekMapper = new LiveGameweekMapper();

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
	 * Returns the total number of players playing FPL.
	 *
	 * @return total number of players.
	 */
	public int getTotalPlayers()
	{
		return getStaticData().getTotalPlayers();
	}

	/**
	 * returns the user with the provided id.
	 *
	 * @param id the id of the user to return
	 *
	 * @return the user
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the user could not be found.
	 */
	public FPLUser getUser(int id)
			  throws XFPLUnavailableException, XFPLAPIResponseException, XFPLResourceNotFound
	{
		return translated(() ->
		{
			JsonUser user = this.fplClient.getUser(id);
			return userMapper.mapUser(user, getTeamMap());
		});
	}

	/**
	 * @return a full list of players in FPL
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the player list could not be found.
	 */
	public List<FPLPlayer> getPlayers()
			  throws XFPLAPIResponseException, XFPLUnavailableException, XFPLResourceNotFound
	{
		return new ArrayList<>(getPlayerMap().values());
	}

	/**
	 * Get the current FPL game-week. returns NULL if there is no current game-week.
	 *
	 * @return
	 *         the game-week of the current FPL game-week.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the game-week list could not be found.
	 */
	public FPLGameweek getCurrentGameweek()
			  throws XFPLAPIResponseException, XFPLUnavailableException, XFPLResourceNotFound
	{
		return getGameweeks().stream().filter(g -> g.isCurrent()).findFirst().orElse(null);
	}

	/**
	 * @return a list of all FPL game-weeks.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the game-week list could not be found.
	 */
	public List<FPLGameweek> getGameweeks()
			  throws XFPLAPIResponseException, XFPLUnavailableException, XFPLResourceNotFound
	{
		JsonStaticData data = getStaticData();
		return data.getEvents()
				  .stream()
				  .map(gameweek -> gameweekMapper.mapGameweek(gameweek))
				  .collect(Collectors.toList());
	}

	/**
	 * Get a list of all fixtures.
	 *
	 * @return a list of all fixtures.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the fixture list could not be found.
	 */
	public List<FPLFixture> getFixtures()
			  throws XFPLUnavailableException, XFPLAPIResponseException, XFPLResourceNotFound
	{
		return translated(() ->
		{
			List<JsonFixture> fplFixtures = this.fplClient.getFixtures();
			return fplFixtures
					  .stream()
					  .map(f -> fixtureMapper.mapFixture(f, getTeamMap())).collect(Collectors.toList());
		});
	}

	/**
	 * Get a list of all teams.
	 *
	 * @return a list of all teams.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the team list could not be found.
	 */
	public List<FPLTeam> getTeams()
			  throws XFPLAPIResponseException, XFPLUnavailableException, XFPLResourceNotFound
	{
		return new ArrayList<>(getTeamMap().values());
	}

	/**
	 * Get history of the user with the provided entry id.
	 *
	 * @param userEntryId The entry id of the user.
	 *
	 * @return a history for the provided user
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the user's history could not be found.
	 */
	public FPLUserHistory getUserHistory(int userEntryId)
			  throws XFPLUnavailableException, XFPLAPIResponseException, XFPLResourceNotFound
	{
		return translated(() ->
		{
			JsonUserHistory userHistory = fplClient.getUserHistory(userEntryId);
			return userHistoryMapper.mapUserHistory(userHistory);
		});
	}

	/**
	 * Get the Entry game week for the provided entry and game week.
	 *
	 * @param entry    The entry.
	 * @param gameweek The game week.
	 *
	 * @return The entry game week.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the entry game week could not be found.
	 */
	public FPLEntryGameweek getEntryGameweek(int entry, int gameweek)
			  throws XFPLUnavailableException, XFPLAPIResponseException, XFPLResourceNotFound
	{
		return translated(() ->
		{
			JsonEntryGameweek entryGameweek = fplClient.getEntryGameweek(entry, gameweek);
			return entryGameweekMapper.mapEntryGameweek(entryGameweek, getPlayerMap());
		});
	}

	/**
	 * Get the FPL player types.
	 *
	 * @return the list of player types.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the player types could not be found.
	 */
	public List<FPLPlayerType> getPlayerTypes()
			  throws XFPLAPIResponseException, XFPLUnavailableException, XFPLResourceNotFound
	{
		JsonStaticData data = getStaticData();

		return data.getElementTypes().stream().map(elemType -> playerTypeMapper.mapPlayerType(elemType))
				  .collect(Collectors.toList());
	}

	/**
	 * Get every player's stats for a single gameweek (minutes, goals, bonus, etc. for that gameweek only),
	 * as opposed to {@link #getPlayers()} which returns season-to-date totals.
	 *
	 * @param gameweek the gameweek number to get live stats for.
	 *
	 * @return the gameweek stats for every player.
	 *
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 * @throws XFPLAPIResponseException if the response from the FPL server could not be interpreted.
	 * @throws XFPLResourceNotFound     if the gameweek could not be found.
	 */
	public List<FPLGameweekPlayerStats> getLiveGameweek(int gameweek)
			  throws XFPLUnavailableException, XFPLAPIResponseException, XFPLResourceNotFound
	{
		return translated(() ->
		{
			JsonLiveGameweek liveGameweek = this.fplClient.getLiveGameweek(gameweek);
			return liveGameweekMapper.mapLiveGameweek(liveGameweek, getPlayerMap());
		});
	}

	private JsonStaticData getStaticData()
			  throws XFPLAPIResponseException, XFPLUnavailableException, XFPLResourceNotFound
	{
		if(cachedData.getStaticData() != null)
		{
			LOGGER.debug("Static data cache hit");
			return cachedData.getStaticData();
		}

		LOGGER.debug("Static data cache miss, fetching from FPL");
		JsonStaticData data = translated(() -> this.fplClient.getStaticData());
		this.cachedData.storeStaticData(data);
		return data;
	}

	/**
	 * Translates internal client exceptions into the public {@code XFPL*} exception hierarchy so that
	 * every public entry point in this class fails in a consistent, documented way.
	 *
	 * @param <T>  the type returned by the client call
	 * @param call the client call to invoke and translate exceptions for
	 *
	 * @return the result of {@code call}
	 */
	private <T> T translated(Supplier<T> call)
			  throws XFPLUnavailableException, XFPLAPIResponseException, XFPLResourceNotFound
	{
		try
		{
			return call.get();
		}
		catch(XConnectionException | XAPIException ex)
		{
			LOGGER.warn("FPL call failed, could not connect or was rejected", ex);
			throw new XFPLUnavailableException(ex.getMessage(), ex);
		}
		catch(XResponseMappingException ex)
		{
			LOGGER.warn("FPL call failed, could not interpret the response", ex);
			throw new XFPLAPIResponseException(ex);
		}
		catch(XResourceNotFound ex)
		{
			LOGGER.warn("FPL call failed, requested resource was not found", ex);
			throw new XFPLResourceNotFound();
		}
	}

	private Map<Integer, FPLTeam> getTeamMap()
	{
		Map<Integer, FPLTeam> teams = cachedData.getTeamMap();
		if(teams == null)
		{
			JsonStaticData data = getStaticData();
			teams = data.getTeams()
					  .stream()
					  .map(t -> teamMapper.mapTeam(t))
					  .collect(Collectors.toMap(t -> t.getId(), t -> t, (a, b) -> a, LinkedHashMap::new));
			cachedData.storeTeamMap(teams);
		}
		return teams;
	}

	private Map<Integer, FPLPlayer> getPlayerMap()
	{
		Map<Integer, FPLPlayer> players = cachedData.getPlayerMap();
		if(players == null)
		{
			JsonStaticData data = getStaticData();
			players = data.getElements()
					  .stream()
					  .map(p -> playerMapper.mapPlayer(p, getTeamMap()))
					  .collect(Collectors.toMap(p -> p.getId(), p -> p, (a, b) -> a, LinkedHashMap::new));
			cachedData.storePlayerMap(players);
		}
		return players;
	}
}
