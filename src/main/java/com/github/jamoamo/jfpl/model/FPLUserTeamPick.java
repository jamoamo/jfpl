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
 * A pick selected for an FPL team.
 *
 * @author James Amoore
 */
public class FPLUserTeamPick
{
	private final int position;
	private final FPLPlayer player;
	private final double sellingPrice;
	private final double purchasingPrice;

	/**
	 * Creates a new instance.
	 *
	 * @param position        The player's position in the team.
	 * @param player          The player
	 * @param sellingPrice    The player's selling price
	 * @param purchasingPrice The price the player was purchased for.
	 */
	public FPLUserTeamPick(int position, FPLPlayer player, double sellingPrice, double purchasingPrice)
	{
		this.position = position;
		this.player = player;
		this.sellingPrice = sellingPrice;
		this.purchasingPrice = purchasingPrice;
	}

	/**
	 * @return The player's position in the FPL team
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 * @return The player
	 */
	public FPLPlayer getPlayer()
	{
		return player;
	}

	/**
	 * @return the price the player can be sold for
	 */
	public double getSellingPrice()
	{
		return sellingPrice;
	}

	/**
	 * @return the price the player was purchased for.
	 */
	public double getPurchasingPrice()
	{
		return purchasingPrice;
	}
}
