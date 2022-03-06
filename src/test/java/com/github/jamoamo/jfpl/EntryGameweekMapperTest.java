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

import com.github.jamoamo.jfpl.model.FPLChip;
import com.github.jamoamo.jfpl.model.FPLEntryGameweek;
import com.github.jamoamo.jfpl.model.FPLGameweekHistory;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author James Amoore
 */
public class EntryGameweekMapperTest
{
	
	public void testMapEntryGameweek()
	{
		JsonEntryGameweek entryGameweek = new JsonEntryGameweek();
		
		entryGameweek.setActiveChip("3xc");
		
		JsonAutomaticSub sub = new JsonAutomaticSub();
		sub.setEvent(17);
		sub.setEntry(190091);
		sub.setElementIn(12);
		sub.setElementOut(1);
		entryGameweek.setAutomaticSubs(Collections.singletonList(sub));
		
		JsonGameweekHistory history = new JsonGameweekHistory();
		history.setBank(40);
		history.setEvent(17);
		history.setEventTransfers(2);
		history.setEventTransfersCost(4);
		history.setOverallRank(1002003);
		history.setPoints(56);
		history.setPointsOnBench(9);
		history.setRank(2221112);
		history.setRankSort(2221114);
		history.setTotalPoints(95);
		history.setValue(996);
		entryGameweek.setEntryHistory(history);
		
		List<JsonGameweekEntryPick> picks = new ArrayList<>();
		
		JsonGameweekEntryPick pick = new JsonGameweekEntryPick();
		pick.setElement(1);
		pick.setPosition(1);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(2);
		pick.setPosition(2);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(3);
		pick.setPosition(3);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(4);
		pick.setPosition(4);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(5);
		pick.setPosition(5);
		pick.setMultiplier(2);
		pick.setIsCaptain(true);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(6);
		pick.setPosition(6);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(7);
		pick.setPosition(7);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(8);
		pick.setPosition(8);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(9);
		pick.setPosition(9);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(true);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(10);
		pick.setPosition(10);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(11);
		pick.setPosition(11);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(12);
		pick.setPosition(12);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(13);
		pick.setPosition(13);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(14);
		pick.setPosition(14);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		pick = new JsonGameweekEntryPick();
		pick.setElement(15);
		pick.setPosition(15);
		pick.setMultiplier(1);
		pick.setIsCaptain(false);
		pick.setIsViceCaptain(false);
		picks.add(pick);
		
		entryGameweek.setPicks(picks);
		
		Map<Integer, FPLPlayer> playerMap = new HashMap<>();
		
		playerMap.put(1, new FPLPlayer(1, "Player", "One", "Player 1", null, FPLPosition.GOALKEEPER, null, null, null, null, null));
		playerMap.put(2, new FPLPlayer(2, "Player", "Two", "Player 2", null, FPLPosition.DEFENDER, null, null, null, null, null));
		playerMap.put(3, new FPLPlayer(3, "Player", "Three", "Player 3", null, FPLPosition.DEFENDER, null, null, null, null, null));
		playerMap.put(4, new FPLPlayer(4, "Player", "Four", "Player 4", null, FPLPosition.DEFENDER, null, null, null, null, null));
		playerMap.put(5, new FPLPlayer(5, "Player", "Five", "Player 5", null, FPLPosition.DEFENDER, null, null, null, null, null));
		playerMap.put(6, new FPLPlayer(6, "Player", "Six", "Player 6", null, FPLPosition.MIDFIELDER, null, null, null, null, null));
		playerMap.put(7, new FPLPlayer(7, "Player", "Seven", "Player 7", null, FPLPosition.MIDFIELDER, null, null, null, null, null));
		playerMap.put(8, new FPLPlayer(8, "Player", "Eight", "Player 8", null, FPLPosition.MIDFIELDER, null, null, null, null, null));
		playerMap.put(9, new FPLPlayer(9, "Player", "Nine", "Player 9", null, FPLPosition.MIDFIELDER, null, null, null, null, null));
		playerMap.put(10, new FPLPlayer(10, "Player", "Ten", "Player 10", null, FPLPosition.FORWARD, null, null, null, null, null));
		playerMap.put(11, new FPLPlayer(11, "Player", "Eleven", "Player 11", null, FPLPosition.FORWARD, null, null, null, null, null));
		playerMap.put(12, new FPLPlayer(12, "Player", "Twelve", "Player 12", null, FPLPosition.GOALKEEPER, null, null, null, null, null));
		playerMap.put(13, new FPLPlayer(13, "Player", "Thirteen", "Player 13", null, FPLPosition.DEFENDER, null, null, null, null, null));
		playerMap.put(14, new FPLPlayer(14, "Player", "Fourteen", "Player 14", null, FPLPosition.MIDFIELDER, null, null, null, null, null));
		playerMap.put(15, new FPLPlayer(15, "Player", "Fifteen", "Player 15", null, FPLPosition.FORWARD, null, null, null, null, null));
		
		EntryGameweekMapper mapper = new EntryGameweekMapper();
		FPLEntryGameweek fplEntryGameweek = mapper.mapEntryGameweek(entryGameweek, playerMap);
		
		assertEquals(15, fplEntryGameweek.getGameweekPicks().size());
		assertEquals(1, fplEntryGameweek.getAutomaticSubstitutions().size());
		assertEquals(FPLChip.TRIPLE_CAPTAIN, fplEntryGameweek.getChipUsed());
		FPLGameweekHistory fgh = fplEntryGameweek.getGameweekHistory();
		assertEquals(4, fgh.getBank());
		assertEquals(95, fgh.getCumulativePoints());
		assertEquals(17, fgh.getGameweek());
		assertEquals(56, fgh.getGameweekPoints());
		assertEquals(2221112, fgh.getGameweekRank());
		assertEquals(2221114, fgh.getGameweekRankSorted());
		assertEquals(2, fgh.getGameweekTransfers());
		assertEquals(4, fgh.getGameweekTransfersCost());
		assertEquals(1002003, fgh.getOverallRank());
		assertEquals(9, fgh.getPointsOnBench());
		assertEquals(99.6, fgh.getValue());
	}
}
