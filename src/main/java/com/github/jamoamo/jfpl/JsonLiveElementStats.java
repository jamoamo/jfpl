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

/**
 * A single element's {@code stats} block from the {@code /event/{id}/live/} endpoint: that element's
 * performance for that gameweek only, as opposed to the season-to-date totals returned by bootstrap-static.
 *
 * @author James Amoore
 */
class JsonLiveElementStats
{
	private int minutes;
	private int goalsScored;
	private int assists;
	private int cleanSheets;
	private int goalsConceded;
	private int ownGoals;
	private int penaltiesSaved;
	private int penaltiesMissed;
	private int yellowCards;
	private int redCards;
	private int saves;
	private int bonus;
	private int bps;
	private int totalPoints;

	public int getMinutes()
	{
		return minutes;
	}

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	public int getGoalsScored()
	{
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored)
	{
		this.goalsScored = goalsScored;
	}

	public int getAssists()
	{
		return assists;
	}

	public void setAssists(int assists)
	{
		this.assists = assists;
	}

	public int getCleanSheets()
	{
		return cleanSheets;
	}

	public void setCleanSheets(int cleanSheets)
	{
		this.cleanSheets = cleanSheets;
	}

	public int getGoalsConceded()
	{
		return goalsConceded;
	}

	public void setGoalsConceded(int goalsConceded)
	{
		this.goalsConceded = goalsConceded;
	}

	public int getOwnGoals()
	{
		return ownGoals;
	}

	public void setOwnGoals(int ownGoals)
	{
		this.ownGoals = ownGoals;
	}

	public int getPenaltiesSaved()
	{
		return penaltiesSaved;
	}

	public void setPenaltiesSaved(int penaltiesSaved)
	{
		this.penaltiesSaved = penaltiesSaved;
	}

	public int getPenaltiesMissed()
	{
		return penaltiesMissed;
	}

	public void setPenaltiesMissed(int penaltiesMissed)
	{
		this.penaltiesMissed = penaltiesMissed;
	}

	public int getYellowCards()
	{
		return yellowCards;
	}

	public void setYellowCards(int yellowCards)
	{
		this.yellowCards = yellowCards;
	}

	public int getRedCards()
	{
		return redCards;
	}

	public void setRedCards(int redCards)
	{
		this.redCards = redCards;
	}

	public int getSaves()
	{
		return saves;
	}

	public void setSaves(int saves)
	{
		this.saves = saves;
	}

	public int getBonus()
	{
		return bonus;
	}

	public void setBonus(int bonus)
	{
		this.bonus = bonus;
	}

	public int getBps()
	{
		return bps;
	}

	public void setBps(int bps)
	{
		this.bps = bps;
	}

	public int getTotalPoints()
	{
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints)
	{
		this.totalPoints = totalPoints;
	}
}
