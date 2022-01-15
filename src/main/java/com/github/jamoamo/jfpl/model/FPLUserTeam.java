/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An FPL user's team.
 *
 * @author James Amoore
 */
public class FPLUserTeam
{
	private final List<FPLUserTeamPick> picks = new ArrayList<>();
	private final List<FPLTeamChip> chips = new ArrayList<>();
	private final FPLPlayer captain;
	private final FPLPlayer viceCaptain;

	/**
	 * Creates a new instance.
	 *
	 * @param picks       The players that make up the user's team
	 * @param chips       The FPL chips for the team
	 * @param captain     The team captain
	 * @param viceCaptain The team vice-captain
	 */
	public FPLUserTeam(List<FPLUserTeamPick> picks, List<FPLTeamChip> chips, FPLPlayer captain, FPLPlayer viceCaptain)
	{
		this.picks.addAll(picks);
		this.chips.addAll(chips);
		this.captain = captain;
		this.viceCaptain = viceCaptain;
	}

	/**
	 * @return The player's in the team
	 */
	public List<FPLUserTeamPick> getPicks()
	{
		return Collections.unmodifiableList(picks);
	}

	/**
	 * @return The team captain
	 */
	public FPLPlayer getCaptain()
	{
		return captain;
	}

	/**
	 * @return The team vice captain
	 */
	public FPLPlayer getViceCaptain()
	{
		return viceCaptain;
	}

	/**
	 * @return The chips available to the team.
	 */
	public List<FPLTeamChip> getChips()
	{
		return Collections.unmodifiableList(chips);
	}
}
