/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 *	Represents a players set piece order.
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
	 * @param directFreeKickOrder player's order for direct free kicks
	 * @param penaltyOrder player's order for penalties
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
