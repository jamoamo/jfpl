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
 * Influence, Creativity and Threat stats for a player.
 *
 * @author James Amoore
 */
public class FPLPlayerICT
{
	private final double influence;
	private final int influenceRank;
	private final int influenceRankType;
	private final double creativity;
	private final int creativityRank;
	private final int creativityRankType;
	private final double threat;
	private final int threatRank;
	private final int threatRankType;
	private final double ictIndex;
	private final int ictIndexRank;
	private final int ictIndexRankType;

	/**
	 * Creates a new instance.
	 *
	 * @param influence          influence rating
	 * @param influenceRank      influence rank
	 * @param influenceRankType  type of the influence rank
	 * @param creativity         creativity rating
	 * @param creativityRank     creativity rank
	 * @param creativityRankType creativity rank type
	 * @param threat             threat rating
	 * @param threatRank         threat rank
	 * @param threatRankType     threat rank type
	 * @param ictIndex           overall ict rating
	 * @param ictIndexRank       overall ict rank
	 * @param ictIndexRankType   overall ict rank type
	 */
	public FPLPlayerICT(double influence,
							  int influenceRank,
							  int influenceRankType,
							  double creativity,
							  int creativityRank,
							  int creativityRankType,
							  double threat,
							  int threatRank,
							  int threatRankType,
							  double ictIndex,
							  int ictIndexRank,
							  int ictIndexRankType)
	{
		this.influence = influence;
		this.influenceRank = influenceRank;
		this.influenceRankType = influenceRankType;
		this.creativity = creativity;
		this.creativityRank = creativityRank;
		this.creativityRankType = creativityRankType;
		this.threat = threat;
		this.threatRank = threatRank;
		this.threatRankType = threatRankType;
		this.ictIndex = ictIndex;
		this.ictIndexRank = ictIndexRank;
		this.ictIndexRankType = ictIndexRankType;
	}

	/**
	 * @return influence rank
	 */
	public int getInfluenceRank()
	{
		return influenceRank;
	}

	/**
	 * @return influence rank type
	 */
	public int getInfluenceRankType()
	{
		return influenceRankType;
	}

	/**
	 * @return creativity rank
	 */
	public int getCreativityRank()
	{
		return creativityRank;
	}

	/**
	 * @return creativity rank type
	 */
	public int getCreativityRankType()
	{
		return creativityRankType;
	}

	/**
	 * @return threat rank
	 */
	public int getThreatRank()
	{
		return threatRank;
	}

	/**
	 * @return threat rank type
	 */
	public int getThreatRankType()
	{
		return threatRankType;
	}

	/**
	 * @return ICT index rank
	 */
	public int getIctIndexRank()
	{
		return ictIndexRank;
	}

	/**
	 * @return ICT index rank type
	 */
	public int getIctIndexRankType()
	{
		return ictIndexRankType;
	}

	/**
	 * @return influence rating
	 */
	public double getInfluence()
	{
		return influence;
	}

	/**
	 * @return creativity rating
	 */
	public double getCreativity()
	{
		return creativity;
	}

	/**
	 * @return threat rating
	 */
	public double getThreat()
	{
		return threat;
	}

	/**
	 * @return ICT index rating
	 */
	public double getIctIndex()
	{
		return ictIndex;
	}
}
