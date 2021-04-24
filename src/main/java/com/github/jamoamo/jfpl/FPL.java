package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLGameweek;
import com.github.jamoamo.jfpl.model.FPLTeam;
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
	
	FPL(IFPLClient client)
	{
		this.fplClient = client;
	}
	
	/**
	 * Get the full list of players in FPL.
	 * @return
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
	 * Get a list of all FPL game-weeks.
	 * @return
	 * @throws XFPLUnavailableException if the client could not connect to the FPL server.
	 */
	public List<FPLGameweek> getGameweeks() 
			  throws XFPLAPIResponseException, XFPLUnavailableException
	{
		JsonStaticData data = getStaticData();
		final GameweekMapper mapper = new GameweekMapper();
		return data.getEvents().stream().map(gameweek -> mapper.mapGameweek(gameweek)).collect(Collectors.toList());
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
}
