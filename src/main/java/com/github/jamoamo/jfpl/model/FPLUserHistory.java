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
package com.github.jamoamo.jfpl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The FPL history for a user. Contains the game week history of the current season and history of past seasons.
 *
 * @author James Amoore
 */
public class FPLUserHistory
{
	private final List<FPLGameweekHistory> gameweekHistory = new ArrayList<>();
	private final List<FPLPastSeason> pastSeasons = new ArrayList<>();

	/**
	 * Creates a new instance.
	 *
	 * @param gameweekHistory Game week history of the current season.
	 * @param pastSeasons     Past seasons points and rank.
	 */
	public FPLUserHistory(List<FPLGameweekHistory> gameweekHistory, List<FPLPastSeason> pastSeasons)
	{
		this.gameweekHistory.addAll(gameweekHistory);
		this.pastSeasons.addAll(pastSeasons);
	}

	/**
	 * @return Game week history of the current season.
	 */
	public List<FPLGameweekHistory> getGameweekHistory()
	{
		return Collections.unmodifiableList(gameweekHistory);
	}

	/**
	 * @return Past seasons points and rank.
	 */
	public List<FPLPastSeason> getPastSeasons()
	{
		return Collections.unmodifiableList(pastSeasons);
	}
}
