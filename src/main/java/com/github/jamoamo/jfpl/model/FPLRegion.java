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
public class FPLRegion
{
	private final int regionId;
	private final String regionName;
	private final String isoCodeLong;
	private final String isoCodeShort;
	
	public FPLRegion(int playerRegionId, String playerRegionName, String playerRegionIsoCodeLong,
						  String playerRegionIsoCodeShort)
	{
		this.regionId = playerRegionId;
		this.regionName = playerRegionName;
		this.isoCodeLong = playerRegionIsoCodeLong;
		this.isoCodeShort = playerRegionIsoCodeShort;
	}

	public int getRegionId()
	{
		return regionId;
	}

	public String getRegionName()
	{
		return regionName;
	}

	public String getIsoCodeLong()
	{
		return isoCodeLong;
	}

	public String getIsoCodeShort()
	{
		return isoCodeShort;
	}
}
