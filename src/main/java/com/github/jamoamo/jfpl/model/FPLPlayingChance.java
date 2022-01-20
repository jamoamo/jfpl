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

/**
 * The player's chance of playing in the current and next game-week.
 *
 * @author James Amoore
 */
public class FPLPlayingChance
{
	private final int chanceNextRound;
	private final int chanceThisRound;

	/**
	 * Creates a new instance.
	 *
	 * @param chanceThisRound The player's chance of playing in the current game-week
	 * @param chanceNextRound The player's chance of playing in the next game-week
	 */
	public FPLPlayingChance(int chanceThisRound, int chanceNextRound)
	{
		this.chanceThisRound = chanceThisRound;
		this.chanceNextRound = chanceNextRound;
	}

	/**
	 * @return The player's chance of playing in the next game-week
	 */
	public int getChanceNextRound()
	{
		return this.chanceNextRound;
	}

	/**
	 * @return The player's chance of playing in the current game-week
	 */
	public int getChanceThisRound()
	{
		return this.chanceThisRound;
	}
}
