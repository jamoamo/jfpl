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

import com.github.jamoamo.jfpl.model.FPLAutomcaticSub;
import com.github.jamoamo.jfpl.model.FPLChip;
import com.github.jamoamo.jfpl.model.FPLEntryGameweek;
import com.github.jamoamo.jfpl.model.FPLGameweekHistory;
import com.github.jamoamo.jfpl.model.FPLGameweekPick;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author James Amoore
 */
final class EntryGameweekMapper
{
	public FPLEntryGameweek mapEntryGameweek(JsonEntryGameweek jsonEntryGameweek, Map<Integer, FPLPlayer> playerMap)
	{
		return new FPLEntryGameweek(mapHistory(jsonEntryGameweek.getEntryHistory()), mapChip(jsonEntryGameweek.
											 getActiveChip()), mapAutomaticSubs(jsonEntryGameweek.getAutomaticSubs(), playerMap),
											 mapGameweekPicks(jsonEntryGameweek.getPicks(), playerMap));
	}
	
	private FPLGameweekHistory mapHistory(JsonGameweekHistory jsonGameweekHistory)
	{
		GameweekHistoryMapper gwMapper = new GameweekHistoryMapper();
		return gwMapper.mapGameweekHistory(jsonGameweekHistory);
	}
	
	private List<FPLAutomcaticSub> mapAutomaticSubs(List<JsonAutomaticSub> subs, Map<Integer, FPLPlayer> playerMap)
	{
		return subs.stream().map(jas -> new FPLAutomcaticSub(playerMap.get(jas.getElementIn()), playerMap.get(jas.
																		getElementOut()))).collect(Collectors.toList());
	}
	
	private FPLChip mapChip(String chipName)
	{
		if(null == chipName)
		{
			return null;
		}
		switch(chipName)
		{
			case "wildcard":
				return FPLChip.WILDCARD;
			case "freehit":
				return FPLChip.FREEHIT;
			case "bboost":
				return FPLChip.BENCH_BOOST;
			case "3xc":
				return FPLChip.TRIPLE_CAPTAIN;
			default:
				return null;
		}
	}
	
	private List<FPLGameweekPick> mapGameweekPicks(List<JsonGameweekEntryPick> gameweekPicks,
																  Map<Integer, FPLPlayer> playerMap)
	{
		return gameweekPicks.stream().map(jgep -> new FPLGameweekPick(playerMap.get(jgep.getElement()), jgep.
																							 getPosition(), jgep.isIsCaptain(), jgep.
																							 isIsViceCaptain())).collect(Collectors.toList());
	}
}
