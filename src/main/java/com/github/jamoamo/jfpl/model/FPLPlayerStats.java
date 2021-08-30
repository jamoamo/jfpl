/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
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
	private final int goalsConceeded;
	private final int ownGoals;
	private final int penaltiesSaved;
	private final int penaltiesMissed;
	private final int yellowCards;
	private final int redCards;
	private final int saves;
	private final int bonus;
	private final int bps;
	
	public FPLPlayerStats(double form, double pointsPerGame, double selectedBy, int totalPoints, double valueForm, double valueSeason,
							double cost, int minutes, int goalsScored, int assists, int cleanSheets, int goalsConceeded, int ownGoals,
							int penaltiesSaved, int penaltiesMissed, int yellowCards, int redCards, int saves, int bonus, int bps)
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
		this.goalsConceeded = goalsConceeded;
		this.ownGoals = ownGoals;
		this.penaltiesSaved = penaltiesSaved;
		this.penaltiesMissed = penaltiesMissed;
		this.yellowCards = yellowCards;
		this.redCards = redCards;
		this.saves = saves;
		this.bonus = bonus;
		this.bps = bps;
	}

	public double getForm()
	{
		return this.form;
	}

	public double getPointsPerGame()
	{
		return this.pointsPerGame;
	}
	
	public double getSelectedBy()
	{
		return this.selectedBy;
	}

	public int getTotalPoints()
	{
		return totalPoints;
	}

	public double getValueForm()
	{
		return valueForm;
	}

	public double getValueSeason()
	{
		return valueSeason;
	}

	public double getCost()
	{
		return cost;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public int getGoalsScored()
	{
		return goalsScored;
	}

	public int getAssists()
	{
		return assists;
	}

	public int getCleanSheets()
	{
		return cleanSheets;
	}

	public int getGoalsConceeded()
	{
		return goalsConceeded;
	}

	public int getOwnGoals()
	{
		return ownGoals;
	}

	public int getPenaltiesSaved()
	{
		return penaltiesSaved;
	}

	public int getPenaltiesMissed()
	{
		return penaltiesMissed;
	}

	public int getYellowCards()
	{
		return yellowCards;
	}

	public int getRedCards()
	{
		return redCards;
	}

	public int getSaves()
	{
		return saves;
	}

	public int getBonus()
	{
		return bonus;
	}

	public int getBps()
	{
		return bps;
	}
}
