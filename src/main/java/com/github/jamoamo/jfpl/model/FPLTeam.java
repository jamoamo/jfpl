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

/**
 * A Premier league team.
 *
 * @author James Amoore
 */
public class FPLTeam
{
	private int id;
	private String name;
	private String shortName;

	/**
	 * Creates a new instance.
	 *
	 * @param id        The team id
	 * @param name      The team name
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
