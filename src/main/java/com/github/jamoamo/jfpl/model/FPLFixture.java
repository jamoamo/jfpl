/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.time.LocalDateTime;

/**
 *	Represents A fixture in FPL.
 * 
 * @author James Amoore
 */
public final class FPLFixture
{
	private final int id;
	private final int gameweek;
	private final LocalDateTime dateTime;
	private final FPLTeam homeTeam;
	private final FPLTeam awayTeam;
	
	/**
	 * Creates a nre instance.
	 * 
	 * @param id The fixture id in FPL
	 * @param gameweek the game-week nr in which the fixture takes place
	 * @param dateTime The Date and time of the fixture
	 * @param homeTeam The team playing at home
	 * @param awayTeam The team playing away from home
	 */
	public FPLFixture(int id, int gameweek, LocalDateTime dateTime, FPLTeam homeTeam, FPLTeam awayTeam)
	{
		this.id = id;
		this.gameweek = gameweek;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.dateTime = dateTime;
	}
	
	/**
	 * @return the fixture id.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the game-week number.
	 */
	public int getGameweek()
	{
		return gameweek;
	}

	/**
	 * @return the home team.
	 */
	public FPLTeam getHomeTeam()
	{
		return homeTeam;
	}

	/**
	 * @return the away team.
	 */
	public FPLTeam getAwayTeam()
	{
		return awayTeam;
	}

	/**
	 * @return the fixture date and time. 
	 */
	public LocalDateTime getDateTime()
	{
		return dateTime;
	}
}
