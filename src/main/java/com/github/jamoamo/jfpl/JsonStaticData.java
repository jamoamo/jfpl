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
	private List<JsonElementType> elementTypes;
	private int totalPlayers;

	JsonStaticData()
	{

	}

	public List<JsonTeam> getTeams()
	{
		return this.teams;
	}

	public void setTeams(List<JsonTeam> teams)
	{
		this.teams = teams;
	}

	public List<JsonPlayer> getElements()
	{
		return this.elements;
	}

	public void setElements(List<JsonPlayer> elements)
	{
		this.elements = elements;
	}

	public List<JsonGameweek> getEvents()
	{
		return this.events;
	}

	public void setEvents(List<JsonGameweek> events)
	{
		this.events = events;
	}

	public List<JsonElementType> getElementTypes()
	{
		return this.elementTypes;
	}

	public void setElementTypes(List<JsonElementType> elementTypes)
	{
		this.elementTypes = elementTypes;
	}

	public int getTotalPlayers()
	{
		return this.totalPlayers;
	}

	public void setTotalPlayers(int totalPlayers)
	{
		this.totalPlayers = totalPlayers;
	}
}
