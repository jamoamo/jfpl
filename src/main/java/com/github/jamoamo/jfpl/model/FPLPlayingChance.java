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
public class FPLPlayingChance
{
	private final int chanceNextRound;
	private final int chanceThisRound;
	
	public FPLPlayingChance(int chanceThisRound, int chanceNextRound)
	{
		this.chanceThisRound = chanceThisRound;
		this.chanceNextRound = chanceNextRound;
	}

	public int getChanceNextRound()
	{
		return this.chanceNextRound;
	}

	public int getChanceThisRound()
	{
		return this.chanceThisRound;
	}
	
	
}
