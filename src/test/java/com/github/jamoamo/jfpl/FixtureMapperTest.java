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
