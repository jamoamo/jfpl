/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
