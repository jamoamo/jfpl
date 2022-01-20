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
 * A player's transfer stats.
 *
 * @author James Amoore
 */
public class FPLPlayerTransfers
{
	private final int transfersIn;
	private final int transfersInEvent;
	private final int transfersOut;
	private final int transfersOutEvent;

	/**
	 * Creates a new instance.
	 *
	 * @param transfersIn       The number of transfers in
	 * @param transfersInEvent  The number of transfers in during the current game-week
	 * @param transfersOut      The number of transfers out
	 * @param transfersOutEvent The number of transfers out during the current game-week
	 */
	public FPLPlayerTransfers(int transfersIn, int transfersInEvent, int transfersOut, int transfersOutEvent)
	{
		this.transfersIn = transfersIn;
		this.transfersInEvent = transfersInEvent;
		this.transfersOut = transfersOut;
		this.transfersOutEvent = transfersOutEvent;
	}

	/**
	 * @return The number of transfers in
	 */
	public int getTransfersIn()
	{
		return transfersIn;
	}

	/**
	 * @return The number of transfers in during the current game-week
	 */
	public int getTransfersInEvent()
	{
		return transfersInEvent;
	}

	/**
	 * @return The number of transfers out
	 */
	public int getTransfersOut()
	{
		return transfersOut;
	}

	/**
	 * @return The number of transfers out during the current game-week
	 */
	public int getTransfersOutEvent()
	{
		return transfersOutEvent;
	}

}
