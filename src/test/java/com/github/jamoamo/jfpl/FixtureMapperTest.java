/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class FixtureMapperTest
{
	
	public FixtureMapperTest()
	{
	}

	/**
	 * Test of mapFixture method, of class FixtureMapper.
	 */
	@Test
	public void testMapFixture()
	{
		JsonFixture jsonFixture = new JsonFixture();
		jsonFixture.setEvent(1);
		jsonFixture.setFinished(true);
		jsonFixture.setKickoffTime("2021-01-08T15:30:00Z");
		jsonFixture.setTeamA(12);
		jsonFixture.setTeamH(13);
		jsonFixture.setTeamHDifficulty(2);
		jsonFixture.setTeamADifficulty(4);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13, new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(14, new FPLTeam(14,"Newcastle", "NEW"));
		teamMap.put(12, new FPLTeam(12,"Man City", "MCI"));
		FixtureMapper instance = new FixtureMapper();
		FPLFixture result = instance.mapFixture(jsonFixture, teamMap);
		assertEquals(jsonFixture.getEvent(), result.getGameweek());
		assertEquals(jsonFixture.getTeamA(), result.getAwayTeam().getId());
		assertEquals(jsonFixture.getTeamH(), result.getHomeTeam().getId());
		assertEquals(2021, result.getDateTime().getYear());
		assertEquals(Month.JANUARY, result.getDateTime().getMonth());
		assertEquals(8, result.getDateTime().getDayOfMonth());
		assertEquals(15, result.getDateTime().getHour());
		assertEquals(30, result.getDateTime().getMinute());
		assertEquals(0, result.getDateTime().getSecond());
		assertEquals(2, result.getHomeDifficulty());
		assertEquals(4, result.getAwayDifficulty());
	}
	
	@Test
	public void testMapFixture_nullDateTime()
	{
		JsonFixture jsonFixture = new JsonFixture();
		jsonFixture.setEvent(1);
		jsonFixture.setFinished(true);
		jsonFixture.setKickoffTime(null);
		jsonFixture.setTeamA(12);
		jsonFixture.setTeamH(13);
		jsonFixture.setTeamHDifficulty(2);
		jsonFixture.setTeamADifficulty(4);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13, new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(14, new FPLTeam(14,"Newcastle", "NEW"));
		teamMap.put(12, new FPLTeam(12,"Man City", "MCI"));
		FixtureMapper instance = new FixtureMapper();
		FPLFixture result = instance.mapFixture(jsonFixture, teamMap);
		assertEquals(jsonFixture.getEvent(), result.getGameweek());
		assertEquals(jsonFixture.getTeamA(), result.getAwayTeam().getId());
		assertEquals(jsonFixture.getTeamH(), result.getHomeTeam().getId());
		assertNull(result.getDateTime());
		assertEquals(2, result.getHomeDifficulty());
		assertEquals(4, result.getAwayDifficulty());
	}
}
