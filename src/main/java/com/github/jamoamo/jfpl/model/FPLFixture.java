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

import java.time.LocalDateTime;

/**
 * Represents A fixture in FPL.
 *
 * @author James Amoore
 */
public final class FPLFixture
{
	private final int id;
	private final int gameweek;
	private final LocalDateTime dateTime;
	private final FPLTeam homeTeam;
	private final FPLTeam awayTeam;
	private final int homeDifficulty;
	private final int awayDifficulty;

	/**
	 * Creates a new instance.
	 *
	 * @param id             The fixture id in FPL
	 * @param gameweek       the game-week nr in which the fixture takes place
	 * @param dateTime       The Date and time of the fixture
	 * @param homeTeam       The team playing at home
	 * @param awayTeam       The team playing away from home
	 * @param homeDifficulty The difficulty of playing the home team
	 * @param awayDifficulty The difficulty of playing the away team
	 */
	public FPLFixture(int id, int gameweek, LocalDateTime dateTime, FPLTeam homeTeam, FPLTeam awayTeam,
							int homeDifficulty, int awayDifficulty)
	{
		this.id = id;
		this.gameweek = gameweek;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.dateTime = dateTime == null ? null : LocalDateTime.from(dateTime);
		this.homeDifficulty = homeDifficulty;
		this.awayDifficulty = awayDifficulty;
	}

	/**
	 * @return the fixture id.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the game-week number.
	 */
	public int getGameweek()
	{
		return gameweek;
	}

	/**
	 * @return the home team.
	 */
	public FPLTeam getHomeTeam()
	{
		return homeTeam;
	}

	/**
	 * @return the away team.
	 */
	public FPLTeam getAwayTeam()
	{
		return awayTeam;
	}

	/**
	 * @return the fixture date and time.
	 */
	public LocalDateTime getDateTime()
	{
		return this.dateTime == null ? null : LocalDateTime.from(dateTime);
	}

	/**
	 * The difficulty of the home team on a scale of 1-5 where 1 is easy and 5 is difficult.
	 *
	 * @return the home difficulty.
	 */
	public int getHomeDifficulty()
	{
		return homeDifficulty;
	}

	/**
	 * The difficulty of the away team on a scale of 1-5 where 1 is easy and 5 is difficult.
	 *
	 * @return the home difficulty.
	 */
	public int getAwayDifficulty()
	{
		return awayDifficulty;
	}

}
