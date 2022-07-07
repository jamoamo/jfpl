/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
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
 * Represents a player type for example Goalkeeper, Defender etc.
 * 
 * @author James Amoore
 */
public final class FPLPlayerType
{
	private final int id;
	private final String name;
	private final String nameShort;
	private final String plural;
	private final String pluralShort;
	private final int numInSquad;
	private final int minPlay;
	private final int maxPlay;

	/**
	 * Creates a new FPlPlayerType.
	 *
	 * @param id          The id of the player type
	 * @param name        The name of the player type e.g. Goalkeeper
	 * @param nameShort   The short name of the player type e.g. GKP.
	 * @param plural      The plural name of the player type e.g. Goalkeepers
	 * @param pluralShort The short plural name of the player type e.g. GKP.
	 * @param numInSquad  The number of the player type allowed in the squad.
	 * @param minPlay     The minimum number of the player type allowed to play.
	 * @param maxPlay     The maximum number of the player type allowed to play.
	 */
	public FPLPlayerType(int id, String name, String nameShort, String plural, String pluralShort, int numInSquad,
								int minPlay, int maxPlay)
	{
		this.id = id;
		this.name = name;
		this.nameShort = nameShort;
		this.plural = plural;
		this.pluralShort = pluralShort;
		this.numInSquad = numInSquad;
		this.minPlay = minPlay;
		this.maxPlay = maxPlay;
	}

	/**
	 * @return The id of the player type.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return The name of the player type.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the short name of the player type.
	 */
	public String getNameShort()
	{
		return nameShort;
	}

	/**
	 * @return the plural name of the player type.
	 */
	public String getPlural()
	{
		return plural;
	}

	/**
	 * @return the short plural name of the player type.
	 */
	public String getPluralShort()
	{
		return pluralShort;
	}

	/**
	 * @return the number of the player squad allowed in the squad.
	 */
	public int getNumInSquad()
	{
		return numInSquad;
	}

	/**
	 * @return the minimum number of the player type allowed to be played.
	 */
	public int getMinPlay()
	{
		return minPlay;
	}

	/**
	 * @return the maximum number of the player type allowed to be played.
	 */
	public int getMaxPlay()
	{
		return maxPlay;
	}

}
