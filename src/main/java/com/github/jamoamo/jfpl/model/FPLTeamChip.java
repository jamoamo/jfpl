/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the So Аftware without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
