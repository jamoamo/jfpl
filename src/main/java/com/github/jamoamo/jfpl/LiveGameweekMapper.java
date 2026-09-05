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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Maps the live-gameweek response from the FPL JSON API to the one exposed by this library.
 *
 * @author James Amoore
 */
class LiveGameweekMapper
{
	protected List<FPLGameweekPlayerStats> mapLiveGameweek(
			  JsonLiveGameweek jsonLiveGameweek, Map<Integer, FPLPlayer> playerMap)
	{
		return jsonLiveGameweek.getElements()
				  .stream()
				  .map(element -> mapElement(element, playerMap))
				  .collect(Collectors.toList());
	}

	private FPLGameweekPlayerStats mapElement(JsonLiveElement element, Map<Integer, FPLPlayer> playerMap)
	{
		JsonLiveElementStats stats = element.getStats();
		return new FPLGameweekPlayerStats(
				  playerMap.get(element.getId()),
				  stats.getMinutes(),
				  stats.getGoalsScored(),
				  stats.getAssists(),
				  stats.getCleanSheets(),
				  stats.getGoalsConceded(),
				  stats.getOwnGoals(),
				  stats.getPenaltiesSaved(),
				  stats.getPenaltiesMissed(),
				  stats.getYellowCards(),
				  stats.getRedCards(),
				  stats.getSaves(),
				  stats.getBonus(),
				  stats.getBps(),
				  stats.getTotalPoints());
	}
}
