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

	/**
	 * Creates a new instance.
	 * @param id the user's id
	 * @param teamName The name of the user's team
	 * @param playerFirstName The user's first name
	 * @param playerLastName The user's last name
	 * @param favuriteTeam The user's favourite team
	 * @param region The region the user lives in
	 */
	public FPLUser(int id, 
					String teamName, 
					String playerFirstName, 
					String playerLastName, 
					FPLTeam favuriteTeam, 
					FPLRegion region)
	{
		this.id = id;
		this.teamName = teamName;
		this.playerFirstName = playerFirstName;
		this.playerLastName = playerLastName;
		this.favouriteTeam = favuriteTeam;
		this.region = region;
	}

	/**
	 * @return The user id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return The user's team name 
	 */
	public String getTeamName()
	{
		return teamName;
	}

	/**
	 * @return The user's first name 
	 */
	public String getPlayerFirstName()
	{
		return playerFirstName;
	}

	/**
	 * @return The user's last name 
	 */
	public String getPlayerLastName()
	{
		return playerLastName;
	}

	/**
	 * @return The user's favourite team 
	 */
	public FPLTeam getFavouriteTeam()
	{
		return favouriteTeam;
	}

	/**
	 * @return The user's region 
	 */
	public FPLRegion getRegion()
	{
		return region;
	}
}
