/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 * Represents a players performance stats.
 *
 * @author James Amoore
 */
public class FPLPlayerStats
{
	private final double form;
	private final double pointsPerGame;
	private final double selectedBy;
	private final int totalPoints;
	private final double valueForm;
	private final double valueSeason;
	private final double cost;
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

	/**
	 * Creates a new instance.
	 *
	 * @param form            the players recent form
	 * @param pointsPerGame   the average number of points gained per game
	 * @param selectedBy      the number of teams the player is selected by
	 * @param totalPoints     the total number of points won by the player
	 * @param valueForm       form divided value
	 * @param valueSeason     season points divided by value
	 * @param cost            The cost of the player
	 * @param minutes         The minutes the player has played
	 * @param goalsScored     the goals scored by the player
	 * @param assists         the assists made by the player
	 * @param cleanSheets     the number of clean sheets checked
	 * @param goalsConceeded  the goals conceded by the player
	 * @param ownGoals        the number of own goals scored
	 * @param penaltiesSaved  the number of penalties saved
	 * @param penaltiesMissed the number of penalties missed
	 * @param yellowCards     the number of yellow cards received
	 * @param redCards        the number of red cards received
	 * @param saves           the number of saves missed
	 * @param bonus           the number of bonus points
	 * @param bps             the number of points gained by the bonus point system
	 */
	public FPLPlayerStats(
			  double form,
			  double pointsPerGame,
			  double selectedBy,
			  int totalPoints,
			  double valueForm,
			  double valueSeason,
			  double cost,
			  int minutes,
			  int goalsScored,
			  int assists,
			  int cleanSheets,
			  int goalsConceeded,
			  int ownGoals,
			  int penaltiesSaved,
			  int penaltiesMissed,
			  int yellowCards,
			  int redCards,
			  int saves,
			  int bonus,
			  int bps)
	{
		this.form = form;
		this.pointsPerGame = pointsPerGame;
		this.selectedBy = selectedBy;
		this.totalPoints = totalPoints;
		this.valueForm = valueForm;
		this.valueSeason = valueSeason;
		this.cost = cost;
		this.minutes = minutes;
		this.goalsScored = goalsScored;
		this.assists = assists;
		this.cleanSheets = cleanSheets;
		this.goalsConceded = goalsConceeded;
		this.ownGoals = ownGoals;
		this.penaltiesSaved = penaltiesSaved;
		this.penaltiesMissed = penaltiesMissed;
		this.yellowCards = yellowCards;
		this.redCards = redCards;
		this.saves = saves;
		this.bonus = bonus;
		this.bps = bps;
	}

	/**
	 * @return the player's form
	 */
	public double getForm()
	{
		return this.form;
	}

	/**
	 * @return points per game
	 */
	public double getPointsPerGame()
	{
		return this.pointsPerGame;
	}

	/**
	 * @return the number of teams selected by
	 */
	public double getSelectedBy()
	{
		return this.selectedBy;
	}

	/**
	 * @return the total points
	 */
	public int getTotalPoints()
	{
		return totalPoints;
	}

	/**
	 * @return the players value by form.
	 */
	public double getValueForm()
	{
		return valueForm;
	}

	/**
	 * @return the player's value over the season
	 */
	public double getValueSeason()
	{
		return valueSeason;
	}

	/**
	 * @return the cost of the player
	 */
	public double getCost()
	{
		return cost;
	}

	/**
	 * @return minutes played
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * @return goals scored
	 */
	public int getGoalsScored()
	{
		return goalsScored;
	}

	/**
	 * @return assists
	 */
	public int getAssists()
	{
		return assists;
	}

	/**
	 * @return number of clean sheets
	 */
	public int getCleanSheets()
	{
		return cleanSheets;
	}

	/**
	 * @return number of goals conceded
	 */
	public int getGoalsConceded()
	{
		return goalsConceded;
	}

	/**
	 * @return number of own goals
	 */
	public int getOwnGoals()
	{
		return ownGoals;
	}

	/**
	 * @return number of penalties saved
	 */
	public int getPenaltiesSaved()
	{
		return penaltiesSaved;
	}

	/**
	 * @return number of penalties missed
	 */
	public int getPenaltiesMissed()
	{
		return penaltiesMissed;
	}

	/**
	 * @return number of yellow cards
	 */
	public int getYellowCards()
	{
		return yellowCards;
	}

	/**
	 * @return number of red cards
	 */
	public int getRedCards()
	{
		return redCards;
	}

	/**
	 * @return number of saves
	 */
	public int getSaves()
	{
		return saves;
	}

	/**
	 * @return number of bonus points
	 */
	public int getBonus()
	{
		return bonus;
	}

	/**
	 * @return the points awarded by the BPS.
	 */
	public int getBps()
	{
		return bps;
	}
}
