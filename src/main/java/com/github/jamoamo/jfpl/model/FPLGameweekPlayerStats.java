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
 * A player's performance in a single gameweek, as returned by the FPL live-gameweek endpoint. Unlike
 * {@link FPLPlayerStats} (which is season-to-date), every figure here pertains to one gameweek only.
 *
 * @author James Amoore
 */
public final class FPLGameweekPlayerStats
{
	private final FPLPlayer player;
	private final int minutes;
	private final int goalsScored;
	private final int assists;
	private final int cleanSheets;
	private final int goalsConceded;
	private final int ownGoals;
	private final int penaltiesSaved;
	private final int penaltiesMissed;
	private final int yellowCards;
	private final int redCards;
	private final int saves;
	private final int bonus;
	private final int bps;
	private final int totalPoints;

	/**
	 * Creates a new instance.
	 *
	 * @param player          the player the stats pertain to
	 * @param minutes         the minutes played in the gameweek
	 * @param goalsScored     the goals scored in the gameweek
	 * @param assists         the assists made in the gameweek
	 * @param cleanSheets     whether a clean sheet was kept in the gameweek (0 or 1)
	 * @param goalsConceded   the goals conceded in the gameweek
	 * @param ownGoals        the own goals scored in the gameweek
	 * @param penaltiesSaved  the penalties saved in the gameweek
	 * @param penaltiesMissed the penalties missed in the gameweek
	 * @param yellowCards     the yellow cards received in the gameweek
	 * @param redCards        the red cards received in the gameweek
	 * @param saves           the saves made in the gameweek
	 * @param bonus           the bonus points awarded for the gameweek
	 * @param bps             the bonus point system score for the gameweek
	 * @param totalPoints     the total FPL points scored in the gameweek
	 */
	public FPLGameweekPlayerStats(
			  FPLPlayer player,
			  int minutes,
			  int goalsScored,
			  int assists,
			  int cleanSheets,
			  int goalsConceded,
			  int ownGoals,
			  int penaltiesSaved,
			  int penaltiesMissed,
			  int yellowCards,
			  int redCards,
			  int saves,
			  int bonus,
			  int bps,
			  int totalPoints)
	{
		this.player = player;
		this.minutes = minutes;
		this.goalsScored = goalsScored;
		this.assists = assists;
		this.cleanSheets = cleanSheets;
		this.goalsConceded = goalsConceded;
		this.ownGoals = ownGoals;
		this.penaltiesSaved = penaltiesSaved;
		this.penaltiesMissed = penaltiesMissed;
		this.yellowCards = yellowCards;
		this.redCards = redCards;
		this.saves = saves;
		this.bonus = bonus;
		this.bps = bps;
		this.totalPoints = totalPoints;
	}

	/**
	 * @return the player the stats pertain to
	 */
	public FPLPlayer getPlayer()
	{
		return player;
	}

	/**
	 * @return minutes played in the gameweek
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * @return goals scored in the gameweek
	 */
	public int getGoalsScored()
	{
		return goalsScored;
	}

	/**
	 * @return assists made in the gameweek
	 */
	public int getAssists()
	{
		return assists;
	}

	/**
	 * @return whether a clean sheet was kept in the gameweek (0 or 1)
	 */
	public int getCleanSheets()
	{
		return cleanSheets;
	}

	/**
	 * @return goals conceded in the gameweek
	 */
	public int getGoalsConceded()
	{
		return goalsConceded;
	}

	/**
	 * @return own goals scored in the gameweek
	 */
	public int getOwnGoals()
	{
		return ownGoals;
	}

	/**
	 * @return penalties saved in the gameweek
	 */
	public int getPenaltiesSaved()
	{
		return penaltiesSaved;
	}

	/**
	 * @return penalties missed in the gameweek
	 */
	public int getPenaltiesMissed()
	{
		return penaltiesMissed;
	}

	/**
	 * @return yellow cards received in the gameweek
	 */
	public int getYellowCards()
	{
		return yellowCards;
	}

	/**
	 * @return red cards received in the gameweek
	 */
	public int getRedCards()
	{
		return redCards;
	}

	/**
	 * @return saves made in the gameweek
	 */
	public int getSaves()
	{
		return saves;
	}

	/**
	 * @return bonus points awarded for the gameweek
	 */
	public int getBonus()
	{
		return bonus;
	}

	/**
	 * @return the bonus point system score for the gameweek
	 */
	public int getBps()
	{
		return bps;
	}

	/**
	 * @return total FPL points scored in the gameweek
	 */
	public int getTotalPoints()
	{
		return totalPoints;
	}
}
