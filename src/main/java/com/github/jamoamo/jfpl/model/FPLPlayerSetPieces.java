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
 * Represents a players set piece order.
 *
 * @author James Amoore
 */
public class FPLPlayerSetPieces
{
	private final int cornersAndIndirectFreeKickOrder;
	private final int directFreeKickOrder;
	private final int penaltyOrder;

	/**
	 * Creates a new instance.
	 *
	 * @param cornersAndIndirectFreeKickOrder player's order for corners and indirect free kicks
	 * @param directFreeKickOrder             player's order for direct free kicks
	 * @param penaltyOrder                    player's order for penalties
	 */
	public FPLPlayerSetPieces(int cornersAndIndirectFreeKickOrder, int directFreeKickOrder, int penaltyOrder)
	{
		this.cornersAndIndirectFreeKickOrder = cornersAndIndirectFreeKickOrder;
		this.directFreeKickOrder = directFreeKickOrder;
		this.penaltyOrder = penaltyOrder;
	}

	/**
	 * @return the player's corner and indirect free kick order
	 */
	public int getCornersAndIndirectFreeKickOrder()
	{
		return cornersAndIndirectFreeKickOrder;
	}

	/**
	 * @return the player's direct free kick order
	 */
	public int getDirectFreeKickOrder()
	{
		return directFreeKickOrder;
	}

	/**
	 * @return the player's penalty order
	 */
	public int getPenaltyOrder()
	{
		return penaltyOrder;
	}
}
