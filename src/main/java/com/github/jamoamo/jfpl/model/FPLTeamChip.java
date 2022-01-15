/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.util.Arrays;

/**
 * An FPL chip with its status for a specific FPL team.
 *
 * @author James Amoore
 */
public class FPLTeamChip
{
	private final FPLChip chip;
	private final FPLChipStatus status;
	private final Integer[] gameweekUsed;
	private final int number;
	private final int startGameweek;
	private final int stopGameweek;

	/**
	 * Creates a new instance.
	 *
	 * @param chip          The chip
	 * @param status        Its current status for the FPL team
	 * @param gameweekUsed  When the chip was used by the FPL team
	 * @param number        The number of this chip
	 * @param startGameweek The first game week this chip can be used
	 * @param stopGameweek  The last game week this chip can be used
	 */
	public FPLTeamChip(FPLChip chip, FPLChipStatus status, Integer[] gameweekUsed, int number, int startGameweek,
							 int stopGameweek)
	{
		this.chip = chip;
		this.status = status;
		this.gameweekUsed = Arrays.copyOf(gameweekUsed, gameweekUsed.length);
		this.number = number;
		this.startGameweek = startGameweek;
		this.stopGameweek = stopGameweek;
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

	/**
	 * @return the number of this chip available.
	 */
	public int getNumber()
	{
		return number;
	}

	/**
	 * @return the last game week that this chip may be used.
	 */
	public int getStopGameweek()
	{
		return this.stopGameweek;
	}

	/**
	 * @return the first game week that this chip may be used.
	 */
	public int getStartGameweek()
	{
		return this.startGameweek;
	}
}
