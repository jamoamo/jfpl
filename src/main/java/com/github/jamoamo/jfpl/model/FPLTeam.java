/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 * A Premier league team.
 * @author James Amoore
 */
public class FPLTeam
{
	private int id;
	private String name;
	private String shortName;
	
	/**
	 * Creates a new instance.
	 * @param id The team id
	 * @param name The team name
	 * @param shortName The short name for the team
	 */
	public FPLTeam(int id, String name, String shortName)
	{
		this.id = id;
		this.name = name;
		this.shortName = shortName;
	}

	/**
	 * @return the team id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the team name 
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the short name for the team 
	 */
	public String getShortName()
	{
		return shortName;
	}
}
