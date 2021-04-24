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
	private final List<FPLPlayer> starting11;
	private final List<FPLPlayer> bench;
	private final FPLPlayer captain;
	private final FPLPlayer viceCaptain;
	
	public FPLUserTeam(List<FPLPlayer> starting11, List<FPLPlayer> bench, FPLPlayer captain, FPLPlayer viceCaptain)
	{
		this.starting11 = starting11;
		this.bench = bench;
		this.captain = captain;
		this.viceCaptain = viceCaptain;
	}

	public List<FPLPlayer> getStarting11()
	{
		return starting11;
	}

	public List<FPLPlayer> getBench()
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
	
	
}
