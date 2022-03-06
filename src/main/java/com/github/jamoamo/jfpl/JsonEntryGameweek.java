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
package com.github.jamoamo.jfpl;

import java.util.List;

/**
 *
 * @author James Amoore
 */
class JsonEntryGameweek
{
	private String activeChip;
	private List<JsonAutomaticSub> automaticSubs;
	private JsonGameweekHistory entryHistory;
	private List<JsonGameweekEntryPick> picks;

	public String getActiveChip()
	{
		return activeChip;
	}

	public void setActiveChip(String activeChip)
	{
		this.activeChip = activeChip;
	}

	public List<JsonAutomaticSub> getAutomaticSubs()
	{
		return automaticSubs;
	}

	public void setAutomaticSubs(List<JsonAutomaticSub> automaticSubs)
	{
		this.automaticSubs = automaticSubs;
	}

	public JsonGameweekHistory getEntryHistory()
	{
		return entryHistory;
	}

	public void setEntryHistory(JsonGameweekHistory entryHistory)
	{
		this.entryHistory = entryHistory;
	}

	public List<JsonGameweekEntryPick> getPicks()
	{
		return picks;
	}

	public void setPicks(List<JsonGameweekEntryPick> picks)
	{
		this.picks = picks;
	}
}
