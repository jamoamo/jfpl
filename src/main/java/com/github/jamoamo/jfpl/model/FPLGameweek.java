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

import java.time.LocalDateTime;

/**
 * Represents an FPL gameweek.
 *
 * @author James Amoore
 */
public final class FPLGameweek
{
	private final int id;
	private final String name;
	private final LocalDateTime deadlineTime;
	private final boolean current;
	private final boolean next;
	private final boolean finished;

	/**
	 * Creates a new FPL gameweek.
	 *
	 * @param id           The gameweek number.
	 * @param name         The name of the gameweek, e.g. Gameweek 1.
	 * @param deadlineTime The deadline by which FPL picks for the gameweek should be made.
	 * @param isCurrent    Whether the gameweek is the current gameweek.
	 * @param isNext       Whether the gameweek is the next gameweek.
	 * @param isFinished   Whether the gameweek has completed.
	 */
	public FPLGameweek(int id, String name, LocalDateTime deadlineTime, boolean isCurrent, boolean isNext,
							 boolean isFinished)
	{
		this.id = id;
		this.name = name;
		this.deadlineTime = LocalDateTime.from(deadlineTime);
		this.current = isCurrent;
		this.next = isNext;
		this.finished = isFinished;
	}

	/**
	 * @return the gameweek number.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the name of the gameweek.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the gameweek deadline by which picks should be made.
	 */
	public LocalDateTime getDeadlineTime()
	{
		return LocalDateTime.from(deadlineTime);
	}

	/**
	 * @return a boolean value indicating if the game-week is the current game-week.
	 */
	public boolean isCurrent()
	{
		return current;
	}

	/**
	 * @return a boolean value indicating if the game-week is the next game-week.
	 */
	public boolean isNext()
	{
		return next;
	}

	/**
	 * @return a boolean value indicating if the game-week has completed
	 */
	public boolean isFinished()
	{
		return finished;
	}
}
