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
 * @author James Amoore
 */
class JsonFixture
{
	private int id;
	private int code;
	private int event;
	private boolean finished;
	private int teamA;
	private int teamH;
	private String kickoffTime;
	private int teamHDifficulty;
	private int teamADifficulty;

	JsonFixture()
	{

	}

	public int getEvent()
	{
		return event;
	}

	public void setEvent(int event)
	{
		this.event = event;
	}

	public boolean isFinished()
	{
		return finished;
	}

	public void setFinished(boolean finished)
	{
		this.finished = finished;
	}

	public int getTeamA()
	{
		return teamA;
	}

	public void setTeamA(int teamA)
	{
		this.teamA = teamA;
	}

	public int getTeamH()
	{
		return teamH;
	}

	public void setTeamH(int teamH)
	{
		this.teamH = teamH;
	}

	public String getKickoffTime()
	{
		return kickoffTime;
	}

	public void setKickoffTime(String kickoffTime)
	{
		this.kickoffTime = kickoffTime;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public int getTeamHDifficulty()
	{
		return teamHDifficulty;
	}

	public void setTeamHDifficulty(int teamHDifficulty)
	{
		this.teamHDifficulty = teamHDifficulty;
	}

	public int getTeamADifficulty()
	{
		return teamADifficulty;
	}

	public void setTeamADifficulty(int teamADifficulty)
	{
		this.teamADifficulty = teamADifficulty;
	}
}
