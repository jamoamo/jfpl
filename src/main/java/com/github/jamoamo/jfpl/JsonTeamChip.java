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
package com.github.jamoamo.jfpl;

/**
 * Team Chip from the FPL JSON.
 *
 * @author James Amoore
 */
class JsonTeamChip
{
	private String statusForEntry;
	private int[] playedByEntry;
	private String name;
	private int number;
	private int startEvent;
	private int stopEvent;
	private String chipType;

	public String getStatusForEntry()
	{
		return statusForEntry;
	}

	public void setStatusForEntry(String statusForEntry)
	{
		this.statusForEntry = statusForEntry;
	}

	public int[] getPlayedByEntry()
	{
		return playedByEntry;
	}

	public void setPlayedByEntry(int[] playedByEntry)
	{
		this.playedByEntry = playedByEntry;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public int getStartEvent()
	{
		return startEvent;
	}

	public void setStartEvent(int startEvent)
	{
		this.startEvent = startEvent;
	}

	public int getStopEvent()
	{
		return stopEvent;
	}

	public void setStopEvent(int stopEvent)
	{
		this.stopEvent = stopEvent;
	}

	public String getChipType()
	{
		return chipType;
	}

	public void setChipType(String chipType)
	{
		this.chipType = chipType;
	}
}
