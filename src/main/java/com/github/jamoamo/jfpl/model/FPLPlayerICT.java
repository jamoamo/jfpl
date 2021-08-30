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
	
	public FPLPlayerICT(double influence, int influenceRank, int influenceRankType, double creativity, int creativityRank, int creativityRankType, double threat, int threatRank, int threatRankType, double ictIndex, int ictIndexRank, int ictIndexRankType)
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

	public double getInfluence()
	{
		return influence;
	}

	public double getCreativity()
	{
		return creativity;
	}

	public double getThreat()
	{
		return threat;
	}

	public double getIctIndex()
	{
		return ictIndex;
	}
}
