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
import com.github.jamoamo.jfpl.model.FPLUserHistory;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class UserHistoryMapperTest
{
	@Test
	public void testMapUserHistory()
	{
		JsonGameweekHistory gameweekHistory = new JsonGameweekHistory();
		gameweekHistory.setEvent(9);
		gameweekHistory.setPoints(59);
		gameweekHistory.setTotalPoints(357);
		gameweekHistory.setRank(1589472);
		gameweekHistory.setRankSort(1589964);
		gameweekHistory.setOverallRank(1209457);
		gameweekHistory.setEventTransfers(2);
		gameweekHistory.setEventTransfersCost(4);
		gameweekHistory.setBank(6);
		gameweekHistory.setValue(1009);
		gameweekHistory.setPointsOnBench(5);
		JsonPastSeasonHistory pastHistory = new JsonPastSeasonHistory();
		pastHistory.setSeasonName("2019/20");
		pastHistory.setTotalPoints(1947);
		pastHistory.setRank(999752);
		JsonUserHistory userHistory = new JsonUserHistory();
		userHistory.setCurrent(Collections.singletonList(gameweekHistory));
		userHistory.setPast(Collections.singletonList(pastHistory));
		UserHistoryMapper mapper = new UserHistoryMapper();

		FPLUserHistory history = mapper.mapUserHistory(userHistory);
		assertEquals(1, history.getGameweekHistory().size());
		FPLGameweekHistory gh = history.getGameweekHistory().get(0);
		assertEquals(9, gh.getGameweek());
		assertEquals(59, gh.getGameweekPoints());
		assertEquals(357, gh.getCumulativePoints());
		assertEquals(1589472, gh.getGameweekRank());
		assertEquals(1589964, gh.getGameweekRankSorted());
		assertEquals(1209457, gh.getOverallRank());
		assertEquals(2, gh.getGameweekTransfers());
		assertEquals(4, gh.getGameweekTransfersCost());
		assertEquals(0.6, gh.getBank());
		assertEquals(100.9, gh.getValue());
		assertEquals(5, gh.getPointsOnBench());
	}
}
