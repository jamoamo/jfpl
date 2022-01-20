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
package com.github.jamoamo.jfpl.model;

/**
 * Represents a users summary for a gameweek.
 *
 * @author James Amoore
 */
public class FPLGameweekSummary
{
	private final int gameweek;
	private final int points;
	private final int gameweekRank;

	/**
	 * Creates a new game-week summary.
	 *
	 * @param gameweek     the game-week nr the summary pertains to
	 * @param points       The number of points the user gained in the game-week.
	 * @param gameweekRank The rank the user placed in the game-week
	 */
	public FPLGameweekSummary(int gameweek, int points, int gameweekRank)
	{
		this.gameweek = gameweek;
		this.points = points;
		this.gameweekRank = gameweekRank;
	}

	/**
	 * @return the game-week the summary pertains to.
	 */
	public int getGameweek()
	{
		return gameweek;
	}

	/**
	 * @return The number of points gained in the game-week.
	 */
	public int getPoints()
	{
		return points;
	}

	/**
	 * @return The rank the user placed in the game-week.
	 */
	public int getGameweekRank()
	{
		return gameweekRank;
	}
}
