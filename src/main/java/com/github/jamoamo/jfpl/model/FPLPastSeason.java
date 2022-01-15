/*
 * The MIT License
 *
 * Copyright 2021 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
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
 * A past FPL season for the user.
 *
 * @author James Amoore
 */
public final class FPLPastSeason
{
	private final String season;
	private final int points;
	private final int rank;

	/**
	 * Creates a new instance.
	 *
	 * @param season The past season e.g. 2008/09.
	 * @param points The number of points scored in the season.
	 * @param rank   The rank achieved in the season.
	 */
	public FPLPastSeason(String season, int points, int rank)
	{
		this.season = season;
		this.points = points;
		this.rank = rank;
	}

	/**
	 * @return The past season e.g. 2008/09.
	 */
	public String getSeason()
	{
		return season;
	}

	/**
	 * @return The number of points scored in the season.
	 */
	public int getPoints()
	{
		return points;
	}

	/**
	 * @return The rank achieved in the season.
	 */
	public int getRank()
	{
		return rank;
	}
}
