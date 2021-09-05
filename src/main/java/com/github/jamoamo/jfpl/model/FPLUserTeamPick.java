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
public class FPLUserTeamPick
{
	private final int position;
	private final FPLPlayer player;
	private final double sellingPrice;
	private final double purchasingPrice;
	
	public FPLUserTeamPick(int position, FPLPlayer player,  double sellingPrice, double purchasingPrice)
	{
		this.position = position;
		this.player = player;
		this.sellingPrice = sellingPrice;
		this.purchasingPrice = purchasingPrice;
	}
	
	public int getPosition()
	{
		return position;
	}

	public FPLPlayer getPlayer()
	{
		return player;
	}
	
	public double getSellingPrice()
	{
		return sellingPrice;
	}

	public double getPurchasingPrice()
	{
		return purchasingPrice;
	}
}
