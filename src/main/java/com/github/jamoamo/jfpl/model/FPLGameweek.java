/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

import java.time.LocalDateTime;

/**
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
	
	public FPLGameweek(int id, String name, LocalDateTime deadlineTime, boolean isCurrent, boolean isNext, boolean isFinished)
	{
		this.id = id;
		this.name = name;
		this.deadlineTime = deadlineTime;
		this.current = isCurrent;
		this.next = isNext;
		this.finished = isFinished;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public LocalDateTime getDeadlineTime()
	{
		return deadlineTime;
	}

	public boolean isCurrent()
	{
		return current;
	}

	public boolean isNext()
	{
		return next;
	}

	public boolean isFinished()
	{
		return finished;
	}
	
	
	
}
