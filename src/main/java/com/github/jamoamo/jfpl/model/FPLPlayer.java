/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 *
 * @author James Amoore
 */
public class FPLPlayer
{
	private final int id;
	private final String firstName;
	private final String lastName;
	private final FPLPosition position;
	private final FPLTeam team;
	
	public FPLPlayer(int id, String firstName, String lastName, FPLTeam team, FPLPosition position)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.team = team;
	}

	public int getId()
	{
		return id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public FPLPosition getPosition()
	{
		return position;
	}

	public FPLTeam getTeam()
	{
		return team;
	}
}
