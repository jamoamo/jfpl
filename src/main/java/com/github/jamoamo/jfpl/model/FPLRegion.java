/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl.model;

/**
 * Region information.
 *
 * @author James Amoore
 */
public class FPLRegion
{
	private final int regionId;
	private final String regionName;
	private final String isoCodeLong;
	private final String isoCodeShort;

	/**
	 * Creates a new instance.
	 *
	 * @param playerRegionId           The region id
	 * @param playerRegionName         The region name
	 * @param playerRegionIsoCodeLong  The region long ISO code
	 * @param playerRegionIsoCodeShort The region short ISO code
	 */
	public FPLRegion(int playerRegionId, String playerRegionName, String playerRegionIsoCodeLong,
						  String playerRegionIsoCodeShort)
	{
		this.regionId = playerRegionId;
		this.regionName = playerRegionName;
		this.isoCodeLong = playerRegionIsoCodeLong;
		this.isoCodeShort = playerRegionIsoCodeShort;
	}

	/**
	 * @return the region id
	 */
	public int getRegionId()
	{
		return regionId;
	}

	/**
	 * @return the regsion name
	 */
	public String getRegionName()
	{
		return regionName;
	}

	/**
	 * @return the region long ISO code
	 */
	public String getIsoCodeLong()
	{
		return isoCodeLong;
	}

	/**
	 * @return the region short ISO code
	 */
	public String getIsoCodeShort()
	{
		return isoCodeShort;
	}
}
