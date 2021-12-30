package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLGameweek;
import com.github.jamoamo.jfpl.model.FPLTeam;
import com.github.jamoamo.jfpl.model.FPLUser;
import com.github.jamoamo.jfpl.model.FPLUserHistory;
import com.github.jamoamo.jfpl.model.FPLUserTeam;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Starting point for accessing the unofficial FPL API.
 */
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
	 * @param creds The FPLLoginCredentials object containing the username and password
	 * @throws XFPLLoginException if something went wrong during authentication
	 */
	public void login(final FPLLoginCredentials creds) throws XFPLLoginException
	{
		boolean loginSuccess = false;
		try
		{
			loginSuccess = this.fplClient.login(creds);
		}
		catch(IOException ex)
		{
			throw new XFPLLoginException(ex);
		}

		if(!loginSuccess)
		{
			throw new XFPLLoginException();
		}
	}
	
	/**
	 * Returns the current user. Requires that the user be logged in using the 
	 * {@link FPL#login(com.github.jamoamo.jfpl.FPLLoginCredentials)} method
	 * 
	 * @return an object representing the current logged in user
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
	 *		the game-week of the current FPL game-week.
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public FPLGameweek getCurrentGameweek() throws XFPLAPIResponseException, XFPLUnavailableException
	{
		return getGameweeks().stream().filter(g -> g.isCurrent()).findFirst().orElse(null);
	}
	
	/**
	 * @return a list of all FPL game-weeks.
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
	 * @return a list of al fixtures.
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
		catch(IOException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(JsonSyntaxException ex)
		{
			throw new XFPLAPIResponseException();
		}
	}

	/**
	 * Get a list of all teams.
	 * @return a list of all teams.
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
	 * @return a history of the current user
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public FPLUserHistory getCurrentUserHistory()
			  throws XFPLUnavailableException
	{
		try
		{
			JsonCurrentUser user = fplClient.getCurrentUser();
			JsonUserHistory history = fplClient.getUserHistory(user.getPlayer().getEntry());

			UserHistoryMapper mapper = new UserHistoryMapper();

			return mapper.mapUserHistory(history);
		}
		catch(IOException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(JsonSyntaxException ex)
		{
			throw new XFPLAPIResponseException();
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
		catch(IOException ex)
		{
			throw new XFPLUnavailableException();
		}
		catch(JsonSyntaxException ex)
		{
			throw new XFPLAPIResponseException();
		}
	}

	private Map<Integer,FPLTeam> getTeamMap()
	{
		Map<Integer,FPLTeam> teams = getTeams()
				  .stream()
				  .collect(Collectors.toMap(t -> t.getId(), t -> t));
		return teams;
	}
	
	private Map<Integer,FPLPlayer> getPlayerMap()
	{
		Map<Integer, FPLPlayer> players = getPlayers()
				  .stream()
				  .collect(Collectors.toMap(p -> p.getId(), p -> p));
		return players;
	}
}
