/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
