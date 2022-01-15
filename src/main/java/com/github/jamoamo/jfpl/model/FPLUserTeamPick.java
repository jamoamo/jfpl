/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
