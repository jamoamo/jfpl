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
public class FPLPlayer
{
	private final int id;
	private final String firstName;
	private final String lastName;
	private final String webName;
	private final FPLPlayerStats playerStats;
	private final FPLPosition position;
	private final FPLTeam team;
	private final FPLPlayingChance playingChance;
	private final FPLPlayerTransfers transfers;
	private final FPLPlayerICT ict;
	private final FPLPlayerSetPieces setPieces;
	
	public FPLPlayer(int id, String firstName, String lastName, String webName, FPLTeam team, FPLPosition position, FPLPlayingChance playingChance, FPLPlayerStats playerStats, FPLPlayerTransfers transfers, FPLPlayerICT ict, FPLPlayerSetPieces setPieces)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.webName = webName;
		this.position = position;
		this.team = team;
		this.playingChance = playingChance;
		this.playerStats = playerStats;
		this.transfers = transfers;
		this.ict = ict;
		this.setPieces = setPieces;
	}

	public int getId()
	{
		return this.id;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public FPLPosition getPosition()
	{
		return this.position;
	}

	public FPLTeam getTeam()
	{
		return this.team;
	}
	
	public String getWebName()
	{
		return this.webName;
	}

	public FPLPlayingChance getPlayingChance()
	{
		return this.playingChance;
	}
	
	public FPLPlayerStats getPlayerStats()
	{
		return this.playerStats;
	}
	
	public FPLPlayerTransfers getTransfers()
	{
		return this.transfers;
	}
	
	public FPLPlayerICT getIct()
	{
		return ict;
	}

	public FPLPlayerSetPieces getSetPieces()
	{
		return setPieces;
	}
}
