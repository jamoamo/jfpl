/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
	 * @param gameweek the game-week nr the summary pertains to
	 * @param points The number of points the user gained in the game-week.
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
