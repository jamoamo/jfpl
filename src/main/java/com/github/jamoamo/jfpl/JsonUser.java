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
class JsonUser
{
	private int id;
	private String playerFirstName;
	private String playerLastName;
	private String playerRegionIsoCodeShort;
	private String playerRegionName;
	private int summaryOverallPoints;
	private int summary_overall_rank;
	private String name;
	private int last_deadline_bank;
	private int last_deadline_value;
	private int last_deadline_total_transfers;
	private int summary_event_points;
	private int summary_event_rank;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getPlayerFirstName()
	{
		return playerFirstName;
	}

	public void setPlayerFirstName(String playerFirstName)
	{
		this.playerFirstName = playerFirstName;
	}

	public String getPlayerLastName()
	{
		return playerLastName;
	}

	public void setPlayerLastName(String playerLastName)
	{
		this.playerLastName = playerLastName;
	}

	public String getPlayerRegionIsoCodeShort()
	{
		return playerRegionIsoCodeShort;
	}

	public void setPlayerRegionIsoCodeShort(String playerRegionIsoCodeShort)
	{
		this.playerRegionIsoCodeShort = playerRegionIsoCodeShort;
	}

	public String getPlayerRegionName()
	{
		return playerRegionName;
	}

	public void setPlayerRegionName(String playerRegionName)
	{
		this.playerRegionName = playerRegionName;
	}
	
	

	public int getSummaryOverallPoints()
	{
		return summaryOverallPoints;
	}

	public void setSummaryOverallPoints(int summaryOverallPoints)
	{
		this.summaryOverallPoints = summaryOverallPoints;
	}

	public int getSummary_overall_rank()
	{
		return summary_overall_rank;
	}

	public void setSummary_overall_rank(int summary_overall_rank)
	{
		this.summary_overall_rank = summary_overall_rank;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLast_deadline_bank()
	{
		return last_deadline_bank;
	}

	public void setLast_deadline_bank(int last_deadline_bank)
	{
		this.last_deadline_bank = last_deadline_bank;
	}

	public int getLast_deadline_value()
	{
		return last_deadline_value;
	}

	public void setLast_deadline_value(int last_deadline_value)
	{
		this.last_deadline_value = last_deadline_value;
	}

	public int getLast_deadline_total_transfers()
	{
		return last_deadline_total_transfers;
	}

	public void setLast_deadline_total_transfers(int last_deadline_total_transfers)
	{
		this.last_deadline_total_transfers = last_deadline_total_transfers;
	}

	public int getSummary_event_points()
	{
		return summary_event_points;
	}

	public void setSummary_event_points(int summary_event_points)
	{
		this.summary_event_points = summary_event_points;
	}

	public int getSummary_event_rank()
	{
		return summary_event_rank;
	}

	public void setSummary_event_rank(int summary_event_rank)
	{
		this.summary_event_rank = summary_event_rank;
	}
}
