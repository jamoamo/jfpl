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
public class FPLTeam
{
	private int id;
	private String name;
	private String shortName;
	
	public FPLTeam(int id, String name, String shortName)
	{
		this.id = id;
		this.name = name;
		this.shortName = shortName;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getShortName()
	{
		return shortName;
	}
}
