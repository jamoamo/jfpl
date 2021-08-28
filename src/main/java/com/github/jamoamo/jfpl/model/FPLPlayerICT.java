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
public class FPLPlayerICT
{
	private final int influenceRank;
	private final int influenceRankType;
	private final int creativityRank;
	private final int creativityRankType;
	private final int threatRank;
	private final int threatRankType;
	private final int ictIndexRank;
	private final int ictIndexRankType;
	
	public FPLPlayerICT(int influenceRank, int influenceRankType, int creativityRank, int creativityRankType, int threatRank, int threatRankType, int ictIndexRank, int ictIndexRankType)
	{
		this.influenceRank = influenceRank;
		this.influenceRankType = influenceRankType;
		this.creativityRank = creativityRank;
		this.creativityRankType = creativityRankType;
		this.threatRank = threatRank;
		this.threatRankType = threatRankType;
		this.ictIndexRank = ictIndexRank;
		this.ictIndexRankType = ictIndexRankType;
	}

	public int getInfluenceRank()
	{
		return influenceRank;
	}

	public int getInfluenceRankType()
	{
		return influenceRankType;
	}

	public int getCreativityRank()
	{
		return creativityRank;
	}

	public int getCreativityRankType()
	{
		return creativityRankType;
	}

	public int getThreatRank()
	{
		return threatRank;
	}

	public int getThreatRankType()
	{
		return threatRankType;
	}

	public int getIctIndexRank()
	{
		return ictIndexRank;
	}

	public int getIctIndexRankType()
	{
		return ictIndexRankType;
	}
	
	
}
