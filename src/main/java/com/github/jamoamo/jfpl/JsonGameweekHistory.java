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

/**
 *
 * @author James Amoore
 */
class JsonGameweekHistory
{
	private int event;
	private int points;
	private int totalPoints;
	private int rank;
	private int rankSort;
	private int overallRank;
	private int bank;
	private int value;
	private int eventTransfers;
	private int eventTransfersCost;
	private int pointsOnBench;

	public int getEvent()
	{
		return event;
	}

	public void setEvent(int event)
	{
		this.event = event;
	}

	public int getPoints()
	{
		return points;
	}

	public void setPoints(int points)
	{
		this.points = points;
	}

	public int getTotalPoints()
	{
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints)
	{
		this.totalPoints = totalPoints;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public int getRankSort()
	{
		return rankSort;
	}

	public void setRankSort(int rankSort)
	{
		this.rankSort = rankSort;
	}

	public int getOverallRank()
	{
		return overallRank;
	}

	public void setOverallRank(int overallRank)
	{
		this.overallRank = overallRank;
	}

	public int getBank()
	{
		return bank;
	}

	public void setBank(int bank)
	{
		this.bank = bank;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public int getEventTransfers()
	{
		return eventTransfers;
	}

	public void setEventTransfers(int eventTransfers)
	{
		this.eventTransfers = eventTransfers;
	}

	public int getEventTransfersCost()
	{
		return eventTransfersCost;
	}

	public void setEventTransfersCost(int eventTransfersCost)
	{
		this.eventTransfersCost = eventTransfersCost;
	}

	public int getPointsOnBench()
	{
		return pointsOnBench;
	}

	public void setPointsOnBench(int pointsOnBench)
	{
		this.pointsOnBench = pointsOnBench;
	}
	
	
}
