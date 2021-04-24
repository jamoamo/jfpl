/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.time.LocalDateTime;

/**
 *
 * @author James Amoore
 */
public class FPLFixture
{
	private final int gameweek;
	private final LocalDateTime dateTime;
	private final FPLTeam homeTeam;
	private final FPLTeam awayTeam;
	
	public FPLFixture(int gameweek, LocalDateTime dateTime, FPLTeam homeTeam, FPLTeam awayTeam)
	{
		this.gameweek = gameweek;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.dateTime = dateTime;
	}

	public int getGameweek()
	{
		return gameweek;
	}

	public FPLTeam getHomeTeam()
	{
		return homeTeam;
	}

	public FPLTeam getAwayTeam()
	{
		return awayTeam;
	}

	public LocalDateTime getDateTime()
	{
		return dateTime;
	}
}
