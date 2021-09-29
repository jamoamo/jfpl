/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 * Represents a player in FPL.
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

	/**
	 * Creates a new instance.
	 *
	 * @param id            The player's id.
	 * @param firstName     The player's first name.
	 * @param lastName      The player's last name.
	 * @param webName       The player's web name.
	 * @param team          The team the player represents.
	 * @param position      The position the player plays.
	 * @param playingChance An object depicting the players chance
	 *                      of playing the coming game-weeks.
	 * @param playerStats   An object representing the players stats.
	 * @param transfers     The number of users that have transferred the player in and out.
	 * @param ict           The players influence creativity and threat stats
	 * @param setPieces     The players likelihood of taking set pieces.
	 */
	public FPLPlayer(int id, String firstName, String lastName, String webName, 
						  FPLTeam team, FPLPosition position,
						  FPLPlayingChance playingChance, FPLPlayerStats playerStats, 
						  FPLPlayerTransfers transfers, FPLPlayerICT ict, 
						  FPLPlayerSetPieces setPieces)
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

	/**
	 * @return the player's id
	 */
	public int getId()
	{
		return this.id;
	}

	/**
	 * @return the player's first name
	 */
	public String getFirstName()
	{
		return this.firstName;
	}

	/**
	 * @return the player's last name
	 */
	public String getLastName()
	{
		return this.lastName;
	}

	/**
	 * @return the position the player plays in.
	 */
	public FPLPosition getPosition()
	{
		return this.position;
	}

	/**
	 * @return the team the player plays in.
	 */
	public FPLTeam getTeam()
	{
		return this.team;
	}

	/**
	 * @return the player's web name.
	 */
	public String getWebName()
	{
		return this.webName;
	}

	/**
	 * @return the player's playing chance.
	 */
	public FPLPlayingChance getPlayingChance()
	{
		return this.playingChance;
	}

	/**
	 * @return the player's stats.
	 */
	public FPLPlayerStats getStats()
	{
		return this.playerStats;
	}

	/**
	 * @return the player's transfer stats.
	 */
	public FPLPlayerTransfers getTransfers()
	{
		return this.transfers;
	}

	/**
	 * @return the player's influence, creativity and threat stats.
	 */
	public FPLPlayerICT getIct()
	{
		return ict;
	}

	/**
	 * @return the player's set piece orders.
	 */
	public FPLPlayerSetPieces getSetPieces()
	{
		return setPieces;
	}
}
