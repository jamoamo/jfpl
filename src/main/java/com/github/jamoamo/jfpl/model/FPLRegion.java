/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the So Аftware without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
