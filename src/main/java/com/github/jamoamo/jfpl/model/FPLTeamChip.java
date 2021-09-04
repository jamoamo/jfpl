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
public class FPLTeamChip
{
	private final FPLChip chip;
	private final FPLChipStatus status;
	private final Integer[] gameweekUsed;
	
	public FPLTeamChip(FPLChip chip, FPLChipStatus status, Integer[] gameweekUsed)
	{
		this.chip = chip;
		this.status = status;
		this.gameweekUsed = gameweekUsed;
	}

	public FPLChip getChip()
	{
		return chip;
	}

	public FPLChipStatus getStatus()
	{
		return status;
	}

	public Integer[] getGameweekUsed()
	{
		return gameweekUsed;
	}
}
