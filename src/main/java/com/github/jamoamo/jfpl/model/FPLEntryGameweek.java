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

import java.util.List;

/**
 * An entries game week.
 * 
 * @author James Amoore
 */
public class FPLEntryGameweek
{
	private final FPLGameweekHistory gameweekHistory;
	private final FPLChip chipUsed;
	private final List<FPLAutomcaticSub> automaticSubstitutions;
	private final List<FPLGameweekPick> gameweekPicks;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param gwHistory Game week History for the entry and game week.
	 * @param chipUsed The chip used in the game week
	 * @param gwSubs Automatic substitutes made in the game week
	 * @param picks The picks for the team in the game week.
	 */
	public FPLEntryGameweek(FPLGameweekHistory gwHistory, 
									FPLChip chipUsed, 
									List<FPLAutomcaticSub> gwSubs, 
									List<FPLGameweekPick> picks)
	{
		this.gameweekHistory = gwHistory;
		this.chipUsed = chipUsed;
		this.automaticSubstitutions = gwSubs;
		this.gameweekPicks = picks;
	}

	/**
	 * Game week History for the entry and game week.
	 * @return the game week history.
	 */
	public FPLGameweekHistory getGameweekHistory()
	{
		return gameweekHistory;
	}

	/**
	 * The chip used in the game week.
	 * @return The chip used. Null if no chip is used.
	 */
	public FPLChip getChipUsed()
	{
		return chipUsed;
	}

	/**
	 * Automatic substitutes made in the game week.
	 * @return the automatic substitutes.
	 */
	public List<FPLAutomcaticSub> getAutomaticSubstitutions()
	{
		return automaticSubstitutions;
	}

	/**
	 * The picks for the team in the game week.
	 * @return the game week picks.
	 */
	public List<FPLGameweekPick> getGameweekPicks()
	{
		return gameweekPicks;
	}
}
