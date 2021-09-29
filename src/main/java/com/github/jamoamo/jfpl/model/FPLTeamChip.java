/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.util.Arrays;

/**
 *	An FPL chip with its status for a specific FPL team.
 * @author James Amoore
 */
public class FPLTeamChip
{
	private final FPLChip chip;
	private final FPLChipStatus status;
	private final Integer[] gameweekUsed;
	
	/**
	 * Creates a new instance.
	 * @param chip The chip
	 * @param status Its current status for the FPL team
	 * @param gameweekUsed When the chip was used by the FPL team
	 */
	public FPLTeamChip(FPLChip chip, FPLChipStatus status, Integer[] gameweekUsed)
	{
		this.chip = chip;
		this.status = status;
		this.gameweekUsed = Arrays.copyOf(gameweekUsed, gameweekUsed.length);
	}

	/**
	 * @return the chip 
	 */
	public FPLChip getChip()
	{
		return chip;
	}

	/**
	 * @return the chip status 
	 */
	public FPLChipStatus getStatus()
	{
		return status;
	}

	/**
	 * @return the game-week(s) in which the chip was used. 
	 */
	public Integer[] getGameweekUsed()
	{
		return Arrays.copyOf(gameweekUsed, gameweekUsed.length);
	}
}
