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
class JsonTeamTransfers
{
	private int cost;
	private String status;
	private int limit;
	private int made;
	private int bank;
	private int value;

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getLimit()
	{
		return limit;
	}

	public void setLimit(int limit)
	{
		this.limit = limit;
	}

	public int getMade()
	{
		return made;
	}

	public void setMade(int made)
	{
		this.made = made;
	}

	public int getBank()
	{
		return bank;
	}

	public void setBank(int bank)
	{
		this.bank = bank;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

}
