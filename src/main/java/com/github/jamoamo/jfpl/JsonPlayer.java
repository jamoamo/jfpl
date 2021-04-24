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
class JsonPlayer
{
	private int chanceOfPlayingNextRound;
	private int chanceOfPlayingThisRound;
	private String firstName;
	private String secondName;
	private int id;
	private int team;
	private int elementType;

	public int getChanceOfPlayingNextRound()
	{
		return chanceOfPlayingNextRound;
	}

	public void setChanceOfPlayingNextRound(int chanceOfPlayingNextRound)
	{
		this.chanceOfPlayingNextRound = chanceOfPlayingNextRound;
	}

	public int getChanceOfPlayingThisRound()
	{
		return chanceOfPlayingThisRound;
	}

	public void setChanceOfPlayingThisRound(int chanceOfPlayingThisRound)
	{
		this.chanceOfPlayingThisRound = chanceOfPlayingThisRound;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSecondName()
	{
		return secondName;
	}

	public void setSecondName(String secondName)
	{
		this.secondName = secondName;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getTeam()
	{
		return team;
	}

	public void setTeam(int team)
	{
		this.team = team;
	}

	public int getElementType()
	{
		return elementType;
	}

	public void setElementType(int element_type)
	{
		this.elementType = element_type;
	}
	
	
}
