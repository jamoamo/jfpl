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
package com.github.jamoamo.jfpl.model;

/**
 * A user's game week performance.
 *
 * @author James Amoore
 */
public class FPLGameweekHistory
{
	private final int gameweek;
	private final int gameweekPoints;
	private final int cumulativePoints;
	private final int gameweekRank;
	private final int gameweekRankSorted;
	private final int overallRank;
	private final double bank;
	private final double value;
	private final int gameweekTransfers;
	private final int gameweekTransfersCost;
	private final int pointsOnBench;

	/**
	 * Creates a new instance.
	 *
	 * @param gameweek              The game week.
	 * @param gameweekPoints        The number of points scored in the game week.
	 * @param cumulativePoints      The overall number of points up to and including this game week.
	 * @param gameweekRank          The user's rank in the game week.
	 * @param gameweekRankSorted    The user's sorted rank in the game week.
	 * @param overallRank           The user's overall rank after the game week.
	 * @param bank                  The amount in the user's bank.
	 * @param value                 The value of the user's team.
	 * @param gameweekTransfers     the number of transfers made in the game week.
	 * @param gameweekTransfersCost the cost of the transfers in the game week.
	 * @param pointsOnBench         the number of points left on the bench.
	 */
	public FPLGameweekHistory(int gameweek, int gameweekPoints, int cumulativePoints, int gameweekRank,
									  int gameweekRankSorted, int overallRank, double bank, double value, int gameweekTransfers,
									  int gameweekTransfersCost, int pointsOnBench)
	{
		this.gameweek = gameweek;
		this.gameweekPoints = gameweekPoints;
		this.cumulativePoints = cumulativePoints;
		this.gameweekRank = gameweekRank;
		this.gameweekRankSorted = gameweekRankSorted;
		this.overallRank = overallRank;
		this.bank = bank;
		this.value = value;
		this.gameweekTransfers = gameweekTransfers;
		this.gameweekTransfersCost = gameweekTransfersCost;
		this.pointsOnBench = pointsOnBench;
	}

	/**
	 * @return The game week.
	 */
	public int getGameweek()
	{
		return gameweek;
	}

	/**
	 * @return The number of points scored in the game week.
	 */
	public int getGameweekPoints()
	{
		return gameweekPoints;
	}

	/**
	 * @return The overall number of points up to and including this game week.
	 */
	public int getCumulativePoints()
	{
		return cumulativePoints;
	}

	/**
	 * @return The user's rank in the game week.
	 */
	public int getGameweekRank()
	{
		return gameweekRank;
	}

	/**
	 * @return The user's sorted rank in the game week.
	 */
	public int getGameweekRankSorted()
	{
		return gameweekRankSorted;
	}

	/**
	 * @return The user's overall rank after the game week.
	 */
	public int getOverallRank()
	{
		return overallRank;
	}

	/**
	 * @return The amount in the user's bank.
	 */
	public double getBank()
	{
		return bank;
	}

	/**
	 * @return The value of the user's team.
	 */
	public double getValue()
	{
		return value;
	}

	/**
	 * @return the number of transfers made in the game week.
	 */
	public int getGameweekTransfers()
	{
		return gameweekTransfers;
	}

	/**
	 * @return the cost of the transfers in the game week.
	 */
	public int getGameweekTransfersCost()
	{
		return gameweekTransfersCost;
	}

	/**
	 * @return the number of points left on the bench.
	 */
	public int getPointsOnBench()
	{
		return pointsOnBench;
	}
}
