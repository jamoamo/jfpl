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
