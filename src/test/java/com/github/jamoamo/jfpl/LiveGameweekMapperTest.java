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

import com.github.jamoamo.jfpl.model.FPLGameweekPlayerStats;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLPosition;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class LiveGameweekMapperTest
{
	/**
	 * Test of mapLiveGameweek method, of class LiveGameweekMapper.
	 */
	@Test
	public void testMapLiveGameweek()
	{
		JsonLiveElementStats stats1 = new JsonLiveElementStats();
		stats1.setMinutes(90);
		stats1.setGoalsScored(2);
		stats1.setAssists(1);
		stats1.setCleanSheets(0);
		stats1.setGoalsConceded(1);
		stats1.setOwnGoals(0);
		stats1.setPenaltiesSaved(0);
		stats1.setPenaltiesMissed(0);
		stats1.setYellowCards(1);
		stats1.setRedCards(0);
		stats1.setSaves(0);
		stats1.setBonus(3);
		stats1.setBps(35);
		stats1.setTotalPoints(14);

		JsonLiveElement element1 = new JsonLiveElement();
		element1.setId(111);
		element1.setStats(stats1);

		JsonLiveGameweek jsonLiveGameweek = new JsonLiveGameweek();
		jsonLiveGameweek.setElements(Arrays.asList(element1));

		Map<Integer, FPLPlayer> playerMap = new HashMap<>();
		FPLTeam team = new FPLTeam(13, "Man Utd", "MUN");
		FPLPlayer player = new FPLPlayer(111, "Bruno", "Fernandes", "Fernandes", team, FPLPosition.MIDFIELDER,
				  null, null, null, null, null);
		playerMap.put(111, player);

		LiveGameweekMapper instance = new LiveGameweekMapper();
		List<FPLGameweekPlayerStats> result = instance.mapLiveGameweek(jsonLiveGameweek, playerMap);

		assertEquals(1, result.size());
		assertEquals(player, result.get(0).getPlayer());
		assertEquals(90, result.get(0).getMinutes());
		assertEquals(2, result.get(0).getGoalsScored());
		assertEquals(1, result.get(0).getAssists());
		assertEquals(0, result.get(0).getCleanSheets());
		assertEquals(1, result.get(0).getGoalsConceded());
		assertEquals(0, result.get(0).getOwnGoals());
		assertEquals(0, result.get(0).getPenaltiesSaved());
		assertEquals(0, result.get(0).getPenaltiesMissed());
		assertEquals(1, result.get(0).getYellowCards());
		assertEquals(0, result.get(0).getRedCards());
		assertEquals(0, result.get(0).getSaves());
		assertEquals(3, result.get(0).getBonus());
		assertEquals(35, result.get(0).getBps());
		assertEquals(14, result.get(0).getTotalPoints());
	}
}
