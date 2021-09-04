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
	private final FPLPlayer player;
	private final double sellingPrice;
	private final double purchasingPrice;
	
	public FPLUserTeamPick(FPLPlayer player,  double sellingPrice, double purchasingPrice)
	{
		this.player = player;
		this.sellingPrice = sellingPrice;
		this.purchasingPrice = purchasingPrice;
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
