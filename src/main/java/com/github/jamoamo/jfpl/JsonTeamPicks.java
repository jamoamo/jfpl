/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 *
 * @author James Amoore
 */
class JsonTeamPick
{
	private int elementId;
	private int position;
	private int sellingPrice;
	private int multiplier;
	private int purchasingPrice;
	private boolean isCaptain;
	private boolean isViceCaptain;

	public int getElementId()
	{
		return elementId;
	}

	public void setElementId(int elementId)
	{
		this.elementId = elementId;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public int getSellingPrice()
	{
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice)
	{
		this.sellingPrice = sellingPrice;
	}

	public int getMultiplier()
	{
		return multiplier;
	}

	public void setMultiplier(int multiplier)
	{
		this.multiplier = multiplier;
	}

	public int getPurchasingPrice()
	{
		return purchasingPrice;
	}

	public void setPurchasingPrice(int purchasingPrice)
	{
		this.purchasingPrice = purchasingPrice;
	}

	public boolean isIsCaptain()
	{
		return isCaptain;
	}

	public void setIsCaptain(boolean isCaptain)
	{
		this.isCaptain = isCaptain;
	}

	public boolean isIsViceCaptain()
	{
		return isViceCaptain;
	}

	public void setIsViceCaptain(boolean isViceCaptain)
	{
		this.isViceCaptain = isViceCaptain;
	}
	
	
}
