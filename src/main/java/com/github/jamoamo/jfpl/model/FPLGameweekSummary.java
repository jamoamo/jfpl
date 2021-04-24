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
public class FPLGameweekSummary
{
	private final int gameweek;
	private final int points;
	private final int gameweekRank;

	public FPLGameweekSummary(int gameweek, int points, int gameweekRank)
	{
		this.gameweek = gameweek;
		this.points  = points;
		this.gameweekRank = gameweekRank;
	}
	
	public int getGameweek()
	{
		return gameweek;
	}

	public int getPoints()
	{
		return points;
	}

	public int getGameweekRank()
	{
		return gameweekRank;
	}
}
