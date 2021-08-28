/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 *
 * @author James Amoore
 */
public class FPLPlayerTransfers
{
	private final int transfersIn;
	private final int transfersInEvent;
	private final int transfersOut;
	private final int transfersOutEvent;
	
	public FPLPlayerTransfers(int transfersIn, int transfersInEvent, int transfersOut, int transfersOutEvent)
	{
		this.transfersIn = transfersIn;
		this.transfersInEvent = transfersInEvent;
		this.transfersOut = transfersOut;
		this.transfersOutEvent = transfersOutEvent;
	}

	public int getTransfersIn()
	{
		return transfersIn;
	}

	public int getTransfersInEvent()
	{
		return transfersInEvent;
	}

	public int getTransfersOut()
	{
		return transfersOut;
	}

	public int getTransfersOutEvent()
	{
		return transfersOutEvent;
	}
	
	
	
}
