/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 *
 * @author James Amoore
 */
class JsonGameweek
{
	private int id;
	private String name;
	private String deadlineTime;
	private int averageEntryScore;
	private int highestScoringEntry;
	private boolean isCurrent;
	private boolean isNext;
	private boolean finished;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDeadlineTime()
	{
		return deadlineTime;
	}

	public void setDeadlineTime(String deadlineTime)
	{
		this.deadlineTime = deadlineTime;
	}

	public int getAverageEntryScore()
	{
		return averageEntryScore;
	}

	public void setAverageEntryScore(int averageEntryScore)
	{
		this.averageEntryScore = averageEntryScore;
	}

	public int getHighestScoringEntry()
	{
		return highestScoringEntry;
	}

	public void setHighestScoringEntry(int highestScoringEntry)
	{
		this.highestScoringEntry = highestScoringEntry;
	}

	public boolean isIsCurrent()
	{
		return isCurrent;
	}

	public void setIsCurrent(boolean isCurrent)
	{
		this.isCurrent = isCurrent;
	}

	public boolean isIsNext()
	{
		return isNext;
	}

	public void setIsNext(boolean isNext)
	{
		this.isNext = isNext;
	}

	public boolean isFinished()
	{
		return finished;
	}

	public void setFinished(boolean finished)
	{
		this.finished = finished;
	}
}
