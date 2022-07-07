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

import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLGameweek;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLPlayerType;
import com.github.jamoamo.jfpl.model.FPLPosition;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class FPLTest
{
	
	public FPLTest()
	{
	}

	/**
	 * Test of getPlayers method, of class FPL.
	 */
	@Test
	public void testGetPlayers()
	{
		List<JsonPlayer> players = new ArrayList<>();
		players.add(createPlayer(1,3,"Bruno", "Fernandes", 12));
		players.add(createPlayer(2,2,"Harry", "Maguire", 12));
		players.add(createPlayer(3,4,"Edison", "Cavani", 12));
		List<JsonTeam> teams = new ArrayList<>();
		teams.add(createTeam(12,"Man Utd", "MUN"));
		
		TestClient testClient = new TestClient();
		testClient.data.setTeams(teams);
		testClient.data.setElements(players);
		
		FPL instance = new FPL(testClient);
		List<FPLPlayer> result = instance.getPlayers();
		assertEquals(3, result.size());
		
		assertEquals(1, result.get(0).getId());
		assertEquals("Bruno", result.get(0).getFirstName());
		assertEquals("Fernandes", result.get(0).getLastName());
		assertEquals(FPLPosition.MIDFIELDER, result.get(0).getPosition());
		assertEquals(12, result.get(0).getTeam().getId());
		
		assertEquals(2, result.get(1).getId());
		assertEquals("Harry", result.get(1).getFirstName());
		assertEquals("Maguire", result.get(1).getLastName());
		assertEquals(FPLPosition.DEFENDER, result.get(1).getPosition());
		assertEquals(12, result.get(1).getTeam().getId());
		
		assertEquals(3, result.get(2).getId());
		assertEquals("Edison", result.get(2).getFirstName());
		assertEquals("Cavani", result.get(2).getLastName());
		assertEquals(FPLPosition.FORWARD, result.get(2).getPosition());
		assertEquals(12, result.get(2).getTeam().getId());
	}
	
	@Test
	public void testGetPlayers_XFPLUnavailableException()
	{
		TestClient testClient = new TestClient();
		testClient.throwIOException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLUnavailableException.class, () -> instance.getPlayers());
	}
	
	@Test
	public void testGetPlayers_XFPLAPIResponseException()
	{
		TestClient testClient = new TestClient();
		testClient.throwAPIException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLAPIResponseException.class, () -> instance.getPlayers());
	}

	/**
	 * Test of getCurrentGameweek method, of class FPL.
	 */
	@Test
	public void testGetCurrentGameweek()
	{
		List<JsonGameweek> gameweeks = new ArrayList<>();
		gameweeks.add(createGameweek(1,"Gameweek 1", "2020-10-12T13:30:50Z", false));
		gameweeks.add(createGameweek(2,"Gameweek 2", "2020-10-12T13:30:50Z", true));
		gameweeks.add(createGameweek(3,"Gameweek 3", "2020-10-12T13:30:50Z", false));
		
		TestClient testClient = new TestClient();
		testClient.data.setEvents(gameweeks);
		
		FPL instance = new FPL(testClient);
		FPLGameweek result = instance.getCurrentGameweek();
		assertEquals(2, result.getId());
	}
	@Test
	public void testGetCurrentGameweek_none()
	{
		List<JsonGameweek> gameweeks = new ArrayList<>();
		gameweeks.add(createGameweek(1,"Gameweek 1", "2020-10-12T13:30:50Z", false));
		gameweeks.add(createGameweek(2,"Gameweek 2", "2020-10-12T13:30:50Z", false));
		gameweeks.add(createGameweek(3,"Gameweek 3", "2020-10-12T13:30:50Z", false));
		
		TestClient testClient = new TestClient();
		testClient.data.setEvents(gameweeks);
		
		FPL instance = new FPL(testClient);
		FPLGameweek result = instance.getCurrentGameweek();
		assertNull(result);
	}
	
	
	@Test
	public void testGetCurrentGameweek_XFPLUnavailableException()
	{
		TestClient testClient = new TestClient();
		testClient.throwIOException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLUnavailableException.class, () -> instance.getCurrentGameweek());
	}
	
	@Test
	public void testGetCurrentGameweek_XFPLAPIResponseException()
	{
		TestClient testClient = new TestClient();
		testClient.throwAPIException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLAPIResponseException.class, () -> instance.getCurrentGameweek());
	}

	/**
	 * Test of getGameweeks method, of class FPL.
	 */
	@Test
	public void testGetGameweeks()
	{
		List<JsonGameweek> gameweeks = new ArrayList<>();
		gameweeks.add(createGameweek(1,"Gameweek 1", "2020-10-12T13:30:50Z", false));
		gameweeks.add(createGameweek(2,"Gameweek 2", "2020-10-12T13:30:50Z", false));
		gameweeks.add(createGameweek(3,"Gameweek 3", "2020-10-12T13:30:50Z", false));
		
		TestClient testClient = new TestClient();
		testClient.data.setEvents(gameweeks);
		
		FPL instance = new FPL(testClient);
		List<FPLGameweek> result = instance.getGameweeks();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetGameweeks_XFPLUnavailableException()
	{
		TestClient testClient = new TestClient();
		testClient.throwIOException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLUnavailableException.class, () -> instance.getGameweeks());
	}
	
	@Test
	public void testGetGameweeks_XFPLAPIResponseException()
	{
		TestClient testClient = new TestClient();
		testClient.throwAPIException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLAPIResponseException.class, () -> instance.getGameweeks());
	}

	/**
	 * Test of getFixtures method, of class FPL.
	 */
	@Test
	public void testGetFixtures()
	{
		List<JsonFixture> fixtures = new ArrayList<>();
		fixtures.add(createFixture(2,12,11,"2020-01-01T12:00:00Z"));
		fixtures.add(createFixture(4,14,15,"2020-02-02T20:15:00Z"));
		fixtures.add(createFixture(6,1,2,"2020-03-04T18:20:00Z"));
		
		List<JsonTeam> teams = new ArrayList<>();
		teams.add(createTeam(12,"Man Utd", "MUN"));
		teams.add(createTeam(11,"Man City", "MCI"));
		teams.add(createTeam(14,"Liverpool", "LIV"));
		teams.add(createTeam(15,"Arsenal", "Ars"));
		teams.add(createTeam(1,"Newcastle", "New"));
		teams.add(createTeam(2,"Leeds", "LEE"));
		TestClient testClient = new TestClient();
		testClient.data.setTeams(teams);
		testClient.fixtures = fixtures;
		
		FPL instance = new FPL(testClient);
		List<FPLFixture> result = instance.getFixtures();
		assertEquals(3, result.size());
		
		assertEquals(2, result.get(0).getGameweek());
		assertEquals(11, result.get(0).getHomeTeam().getId());
		assertEquals(12, result.get(0).getAwayTeam().getId());
		assertEquals(2020, result.get(0).getDateTime().getYear());
		assertEquals(Month.JANUARY, result.get(0).getDateTime().getMonth());
		assertEquals(1, result.get(0).getDateTime().getDayOfMonth());
		assertEquals(12, result.get(0).getDateTime().getHour());
		assertEquals(0, result.get(0).getDateTime().getMinute());
		assertEquals(0, result.get(0).getDateTime().getSecond());
		
		assertEquals(4, result.get(1).getGameweek());
		assertEquals(15, result.get(1).getHomeTeam().getId());
		assertEquals(14, result.get(1).getAwayTeam().getId());
		assertEquals(2020, result.get(1).getDateTime().getYear());
		assertEquals(Month.FEBRUARY, result.get(1).getDateTime().getMonth());
		assertEquals(2, result.get(1).getDateTime().getDayOfMonth());
		assertEquals(20, result.get(1).getDateTime().getHour());
		assertEquals(15, result.get(1).getDateTime().getMinute());
		assertEquals(0, result.get(1).getDateTime().getSecond());
		
		assertEquals(6, result.get(2).getGameweek());
		assertEquals(2, result.get(2).getHomeTeam().getId());
		assertEquals(1, result.get(2).getAwayTeam().getId());
		assertEquals(2020, result.get(2).getDateTime().getYear());
		assertEquals(Month.MARCH, result.get(2).getDateTime().getMonth());
		assertEquals(4, result.get(2).getDateTime().getDayOfMonth());
		assertEquals(18, result.get(2).getDateTime().getHour());
		assertEquals(20, result.get(2).getDateTime().getMinute());
		assertEquals(0, result.get(2).getDateTime().getSecond());
	}
	
	@Test
	public void testGetFixtures_XFPLUnavailableException()
	{
		TestClient testClient = new TestClient();
		testClient.throwIOException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLUnavailableException.class, () -> instance.getFixtures());
	}
	
	@Test
	public void testGetFixtures_XFPLAPIResponseException()
	{
		TestClient testClient = new TestClient();
		testClient.throwAPIException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLAPIResponseException.class, () -> instance.getFixtures());
	}

	/**
	 * Test of getTeams method, of class FPL.
	 */
	@Test
	public void testGetTeams()
	{
		List<JsonTeam> teams = new ArrayList<>();
		teams.add(createTeam(1,"Man Utd", "MUN"));
		teams.add(createTeam(2,"Man City", "MCI"));
		teams.add(createTeam(3,"Liverpool", "LIV"));
		TestClient testClient = new TestClient();
		testClient.data.setTeams(teams);
		
		FPL instance = new FPL(testClient);
		List<FPLTeam> result = instance.getTeams();
		assertEquals(3, result.size());
		
		assertEquals(1, result.get(0).getId());
		assertEquals("Man Utd", result.get(0).getName());
		assertEquals("MUN", result.get(0).getShortName());
		
		assertEquals(2, result.get(1).getId());
		assertEquals("Man City", result.get(1).getName());
		assertEquals("MCI", result.get(1).getShortName());
		
		assertEquals(3, result.get(2).getId());
		assertEquals("Liverpool", result.get(2).getName());
		assertEquals("LIV", result.get(2).getShortName());
	}
	
	@Test
	public void testGetTeams_XFPLUnavailableException()
	{
		TestClient testClient = new TestClient();
		testClient.throwIOException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLUnavailableException.class, () -> instance.getTeams());
	}
	
	@Test
	public void testGetTeams_XFPLAPIResponseException()
	{
		TestClient testClient = new TestClient();
		testClient.throwAPIException = true;
		
		FPL instance = new FPL(testClient);
		assertThrows(XFPLAPIResponseException.class, () -> instance.getTeams());
	}
	
	@Test
	public void testGetPlayerTypes()
	{
		List<JsonElementType> elementTypes = new ArrayList<>();
		elementTypes.add(createElementType(1, "Goalkeeper", "GKP", "Goalkeepers", "GKP", 2, 1, 1));
		elementTypes.add(createElementType(2, "Defender", "DEF", "Defenders", "DEF", 5, 3, 5));
		elementTypes.add(createElementType(3, "Midfielder", "MID", "Midfielders", "MID", 5, 3, 5));
		elementTypes.add(createElementType(4, "Forward", "FOR", "Forwards", "FOR", 3, 1, 3));
		TestClient testClient = new TestClient();
		testClient.data.setElementTypes(elementTypes);
		
		FPL instance = new FPL(testClient);
		List<FPLPlayerType> playerTypes = instance.getPlayerTypes();
		assertEquals(4, playerTypes.size());
		
		assertEquals(1, playerTypes.get(0).getId());
		assertEquals("Goalkeeper", playerTypes.get(0).getName());
		assertEquals("GKP", playerTypes.get(0).getNameShort());
		assertEquals("Goalkeepers", playerTypes.get(0).getPlural());
		assertEquals("GKP", playerTypes.get(0).getPluralShort());
		assertEquals(2, playerTypes.get(0).getNumInSquad());
		assertEquals(1, playerTypes.get(0).getMinPlay());
		assertEquals(1, playerTypes.get(0).getMaxPlay());
		
		assertEquals(2, playerTypes.get(1).getId());
		assertEquals("Defender", playerTypes.get(1).getName());
		assertEquals("DEF", playerTypes.get(1).getNameShort());
		assertEquals("Defenders", playerTypes.get(1).getPlural());
		assertEquals("DEF", playerTypes.get(1).getPluralShort());
		assertEquals(5, playerTypes.get(1).getNumInSquad());
		assertEquals(3, playerTypes.get(1).getMinPlay());
		assertEquals(5, playerTypes.get(1).getMaxPlay());
		
		assertEquals(3, playerTypes.get(2).getId());
		assertEquals("Midfielder", playerTypes.get(2).getName());
		assertEquals("MID", playerTypes.get(2).getNameShort());
		assertEquals("Midfielders", playerTypes.get(2).getPlural());
		assertEquals("MID", playerTypes.get(2).getPluralShort());
		assertEquals(5, playerTypes.get(2).getNumInSquad());
		assertEquals(3, playerTypes.get(2).getMinPlay());
		assertEquals(5, playerTypes.get(2).getMaxPlay());
		
		assertEquals(4, playerTypes.get(3).getId());
		assertEquals("Forward", playerTypes.get(3).getName());
		assertEquals("FOR", playerTypes.get(3).getNameShort());
		assertEquals("Forwards", playerTypes.get(3).getPlural());
		assertEquals("FOR", playerTypes.get(3).getPluralShort());
		assertEquals(3, playerTypes.get(3).getNumInSquad());
		assertEquals(1, playerTypes.get(3).getMinPlay());
		assertEquals(3, playerTypes.get(3).getMaxPlay());
	}
	
	private JsonElementType createElementType(int id, String name, String shortName, String plural, String pluralShort, int number, int minPlay, int maxPlay)
	{
		JsonElementType type = new JsonElementType();
		type.setId(id);
		type.setSingularName(name);
		type.setSingularNameShort(shortName);
		type.setPluralName(plural);
		type.setPluralNameShort(pluralShort);
		type.setSquadSelect(number);
		type.setSquadMaxPlay(maxPlay);
		type.setSquadMinPlay(minPlay);
		return type;
	}
	
	private JsonTeam createTeam(int id, String name, String shortName)
	{
		JsonTeam team = new JsonTeam();
		team.setId(id);
		team.setName(name);
		team.setShortName(shortName);
		return team;
	}

	private JsonFixture createFixture(int event, int aTeam, int hTeam, String date)
	{
		JsonFixture fixture = new JsonFixture();
		fixture.setTeamA(aTeam);
		fixture.setTeamH(hTeam);
		fixture.setEvent(event);
		fixture.setKickoffTime(date);
		fixture.setFinished(true);
		return fixture;
	}

	private JsonGameweek createGameweek(int id, String name, String deadline, boolean isCurrent)
	{
		JsonGameweek gw = new JsonGameweek();
		gw.setId(id);
		gw.setName(name);
		gw.setDeadlineTime(deadline);
		gw.setIsCurrent(isCurrent);
		return gw;
	}

	private JsonPlayer createPlayer(int id, int position, String name, String surname, int team)
	{
		JsonPlayer player = new JsonPlayer();
		player.setId(id);
		player.setFirstName(name);
		player.setSecondName(surname);
		player.setElementType(position);
		player.setTeam(team);
		return player;
	}
	
}
