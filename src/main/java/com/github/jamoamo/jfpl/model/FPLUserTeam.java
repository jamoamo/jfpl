/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.util.List;

/**
 *
 * @author James Amoore
 */
public class FPLUserTeam
{
	private final List<FPLUserTeamPick> starting11;
	private final List<FPLUserTeamPick> bench;
	private final List<FPLTeamChip> chips;
	private final FPLPlayer captain;
	private final FPLPlayer viceCaptain;
	
	public FPLUserTeam(List<FPLUserTeamPick> starting11, List<FPLUserTeamPick> bench, List<FPLTeamChip> chips, FPLPlayer captain, FPLPlayer viceCaptain)
	{
		this.starting11 = starting11;
		this.bench = bench;
		this.chips = chips;
		this.captain = captain;
		this.viceCaptain = viceCaptain;
	}

	public List<FPLUserTeamPick> getStarting11()
	{
		return starting11;
	}

	public List<FPLUserTeamPick> getBench()
	{
		return bench;
	}

	public FPLPlayer getCaptain()
	{
		return captain;
	}

	public FPLPlayer getViceCaptain()
	{
		return viceCaptain;
	}
	
	public List<FPLTeamChip> getChips()
	{
		return chips;
	}
}
