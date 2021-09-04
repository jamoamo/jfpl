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
public class FPLUser
{
	private final int id;
	private final String teamName;
	private final String playerFirstName;
	private final String playerLastName;
	private final FPLTeam favouriteTeam;
	private final FPLRegion region;

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

	public int getId()
	{
		return id;
	}

	public String getTeamName()
	{
		return teamName;
	}

	public String getPlayerFirstName()
	{
		return playerFirstName;
	}

	public String getPlayerLastName()
	{
		return playerLastName;
	}

	public FPLTeam getFavouriteTeam()
	{
		return favouriteTeam;
	}

	public FPLRegion getRegion()
	{
		return region;
	}

	
}
