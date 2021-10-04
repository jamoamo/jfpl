/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 * An FPL User.
 * @author James Amoore
 */
public class FPLUser
{
	private final int id;
	private final String teamName;
	private final String playerFirstName;
	private final String playerLastName;
	private final FPLTeam favouriteTeam;
	private final FPLRegion region;
	private final double lastDeadlineBank;

	/**
	 * Creates a new instance.
	 * @param id the user's id
	 * @param teamName The name of the user's team
	 * @param playerFirstName The user's first name
	 * @param playerLastName The user's last name
	 * @param favouriteTeam The user's favourite team
	 * @param region The region the user lives in
	 * @param bank The team's bank value at the last deadline
	 */
	public FPLUser(int id, 
					String teamName, 
					String playerFirstName, 
					String playerLastName, 
					FPLTeam favouriteTeam, 
					FPLRegion region,
					double bank)
	{
		this.id = id;
		this.teamName = teamName;
		this.playerFirstName = playerFirstName;
		this.playerLastName = playerLastName;
		this.favouriteTeam = favouriteTeam;
		this.region = region;
		this.lastDeadlineBank = bank;
	}

	/**
	 * @return The user id
	 */
	public int getId()
	{
		return this.id;
	}

	/**
	 * @return The user's team name 
	 */
	public String getTeamName()
	{
		return this.teamName;
	}

	/**
	 * @return The user's first name 
	 */
	public String getPlayerFirstName()
	{
		return this.playerFirstName;
	}

	/**
	 * @return The user's last name 
	 */
	public String getPlayerLastName()
	{
		return this.playerLastName;
	}

	/**
	 * @return The user's favourite team 
	 */
	public FPLTeam getFavouriteTeam()
	{
		return this.favouriteTeam;
	}

	/**
	 * @return The user's region 
	 */
	public FPLRegion getRegion()
	{
		return this.region;
	}
	
	/**
	 * @return The teams bank amount at the last deadline.
	 */
	public double getLastDeadlineBank()
	{
		return this.lastDeadlineBank;
	}
}
