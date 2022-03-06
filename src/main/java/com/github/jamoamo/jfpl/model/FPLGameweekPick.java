/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
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

/**
 * A pick for the game week.
 * 
 * @author James Amoore
 */
public class FPLGameweekPick
{
	private final FPLPlayer player;
	private final int position;
	private final boolean captain;
	private final boolean viceCaptain;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param player The player picked.
	 * @param position The position in the team
	 * @param captain If the player was captain in the game week.
	 * @param viceCaptain If the player was vice captain in the game week.
	 */
	public FPLGameweekPick(FPLPlayer player, int position, boolean captain, boolean viceCaptain)
	{
		this.player = player;
		this.position = position;
		this.captain = captain;
		this.viceCaptain = viceCaptain;
	}

	/**
	 * The player picked.
	 * @return the picked player. 
	 */
	public FPLPlayer getPlayer()
	{
		return player;
	}

	/**
	 * The position in the team.
	 * @return integer indicating the position.
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 * Indicates if the pick was the captain in the game week.
	 * @return {@code true} if the pick was captain, else {@code false}.
	 */
	public boolean isCaptain()
	{
		return captain;
	}

	/**
	 * Indicates if the pick was the vice-captain in the game week.
	 * @return {@code true} if the pick was vice-captain, else {@code false}.
	 */
	public boolean isViceCaptain()
	{
		return viceCaptain;
	}
}
