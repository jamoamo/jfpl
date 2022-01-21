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
	private boolean isPrevious;
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

	public boolean isIsPrevious()
	{
		return isPrevious;
	}

	public void setIsPrevious(boolean isPrevious)
	{
		this.isPrevious = isPrevious;
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
