/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
