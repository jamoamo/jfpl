/*
 * The MIT License
 *
 * Copyright 2021 James Amoore.
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

import com.github.jamoamo.jfpl.model.FPLGameweekHistory;
import com.github.jamoamo.jfpl.model.FPLPastSeason;
import com.github.jamoamo.jfpl.model.FPLUserHistory;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author James Amoore
 */
class UserHistoryMapper
{
	private static final double FACTOR_TEN = 10.0;

	protected FPLUserHistory mapUserHistory(JsonUserHistory userHistory)
	{
		List<FPLGameweekHistory> gameweekHistory = mapGameweekHistory(userHistory.getCurrent());
		List<FPLPastSeason> pastSeasons = mapPastSeasons(userHistory.getPast());
		return new FPLUserHistory(gameweekHistory, pastSeasons);
	}

	protected List<FPLGameweekHistory> mapGameweekHistory(List<JsonGameweekHistory> current)
	{
		return current.stream().map(
				  jgh -> new FPLGameweekHistory(jgh.getEvent(), jgh.getPoints(), jgh.getTotalPoints(),
															 jgh.getRank(), jgh.getRankSort(), jgh.getOverallRank(),
															 jgh.getBank() / FACTOR_TEN,
															 jgh.getValue() / FACTOR_TEN, jgh.getEventTransfers(),
															 jgh.getEventTransfersCost(), jgh.getPointsOnBench())).
				  collect(Collectors.toList());
	}

	protected List<FPLPastSeason> mapPastSeasons(List<JsonPastSeasonHistory> past)
	{
		return past.stream().map(jpsh -> new FPLPastSeason(jpsh.getSeasonName(), jpsh.getTotalPoints(), jpsh.getRank())).
				  collect(Collectors.toList());
	}
}
