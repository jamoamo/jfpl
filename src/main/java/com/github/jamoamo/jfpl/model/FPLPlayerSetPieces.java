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
public class FPLPlayerSetPieces
{
	private final int cornersAndIndirectFreeKickOrder;
	private final int directFreeKickOrder;
	private final int penaltyOrder;
	
	public FPLPlayerSetPieces(int cornersAndIndirectFreeKickOrder, int directFreeKickOrder, int penaltyOrder)
	{
		this.cornersAndIndirectFreeKickOrder = cornersAndIndirectFreeKickOrder;
		this.directFreeKickOrder = directFreeKickOrder;
		this.penaltyOrder = penaltyOrder;
	}

	public int getCornersAndIndirectFreeKickOrder()
	{
		return cornersAndIndirectFreeKickOrder;
	}

	public int getDirectFreeKickOrder()
	{
		return directFreeKickOrder;
	}

	public int getPenaltyOrder()
	{
		return penaltyOrder;
	}
	
	
}
