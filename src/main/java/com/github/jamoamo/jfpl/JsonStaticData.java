/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import java.util.List;

/**
 *
 * @author James Amoore
 */
class JsonStaticData
{
	private List<JsonTeam> teams;
	private List<JsonPlayer> elements;
	private List<JsonGameweek> events;

	JsonStaticData()
	{

	}

	public List<JsonTeam> getTeams()
	{
		return teams;
	}

	public void setTeams(List<JsonTeam> teams)
	{
		this.teams = teams;
	}

	public List<JsonPlayer> getElements()
	{
		return elements;
	}

	public void setElements(List<JsonPlayer> elements)
	{
		this.elements = elements;
	}

	public List<JsonGameweek> getEvents()
	{
		return events;
	}

	public void setEvents(List<JsonGameweek> events)
	{
		this.events = events;
	}
}
