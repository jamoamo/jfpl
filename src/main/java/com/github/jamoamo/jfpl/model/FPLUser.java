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
 * An FPL User.
 *
 * @author James Amoore
 */
public class FPLUser
{
	private final int id;
	private final String teamName;
	private final String playerFirstName;
	private final String playerLastName;
	private final FPLTeam favouriteTeam;
	private final FPLRegion region;
	private final double lastDeadlineBank;

	/**
	 * Creates a new instance.
	 *
	 * @param id              the user's id
	 * @param teamName        The name of the user's team
	 * @param playerFirstName The user's first name
	 * @param playerLastName  The user's last name
	 * @param favouriteTeam   The user's favourite team
	 * @param region          The region the user lives in
	 * @param bank            The team's bank value at the last deadline
	 */
	public FPLUser(int id,
						String teamName,
						String playerFirstName,
						String playerLastName,
						FPLTeam favouriteTeam,
						FPLRegion region,
						double bank)
	{
		this.id = id;
		this.teamName = teamName;
		this.playerFirstName = playerFirstName;
		this.playerLastName = playerLastName;
		this.favouriteTeam = favouriteTeam;
		this.region = region;
		this.lastDeadlineBank = bank;
	}

	/**
	 * @return The user id
	 */
	public int getId()
	{
		return this.id;
	}

	/**
	 * @return The user's team name
	 */
	public String getTeamName()
	{
		return this.teamName;
	}

	/**
	 * @return The user's first name
	 */
	public String getPlayerFirstName()
	{
		return this.playerFirstName;
	}

	/**
	 * @return The user's last name
	 */
	public String getPlayerLastName()
	{
		return this.playerLastName;
	}

	/**
	 * @return The user's favourite team
	 */
	public FPLTeam getFavouriteTeam()
	{
		return this.favouriteTeam;
	}

	/**
	 * @return The user's region
	 */
	public FPLRegion getRegion()
	{
		return this.region;
	}

	/**
	 * @return The teams bank amount at the last deadline.
	 */
	public double getLastDeadlineBank()
	{
		return this.lastDeadlineBank;
	}
}
