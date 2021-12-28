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
