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
	private int playerRegionId;
	private String playerRegionIsoCodeShort;
	private String playerRegionIsoCodeLong;
	private String playerRegionName;
	private int summaryOverallPoints;
	private int summaryOverallRank;
	private String name;
	private int lastDeadlineBank;
	private int lastDeadlineValue;
	private int lastDeadlineTotalTransfers;
	private int summaryEventPoints;
	private int summaryEventRank;
	private int favouriteTeam;
	private String joinedTime;
	private int startedEvent;
	private int currentEvent;
	private JsonUserLeagues[] leagues;
	private boolean nameChangeBlocked;
	private String kit;

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

	public int getSummaryOverallRank()
	{
		return summaryOverallRank;
	}

	public void setSummaryOverallRank(int summaryOverallRank)
	{
		this.summaryOverallRank = summaryOverallRank;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLastDeadlineBank()
	{
		return lastDeadlineBank;
	}

	public void setLastDeadlineBank(int lastDeadlineBank)
	{
		this.lastDeadlineBank = lastDeadlineBank;
	}

	public int getLastDeadlineValue()
	{
		return lastDeadlineValue;
	}

	public void setLastDeadlineValue(int lastDeadlineValue)
	{
		this.lastDeadlineValue = lastDeadlineValue;
	}

	public int getLastDeadlineTotalTransfers()
	{
		return lastDeadlineTotalTransfers;
	}

	public void setLastDeadlineTotalTransfers(int lastDeadlineTotalTransfers)
	{
		this.lastDeadlineTotalTransfers = lastDeadlineTotalTransfers;
	}

	public int getSummaryEventPoints()
	{
		return summaryEventPoints;
	}

	public void setSummaryEventPoints(int summaryEventPoints)
	{
		this.summaryEventPoints = summaryEventPoints;
	}

	public int getSummaryEventRank()
	{
		return summaryEventRank;
	}

	public void setSummaryEventRank(int summaryEventRank)
	{
		this.summaryEventRank = summaryEventRank;
	}

	public int getPlayerRegionId()
	{
		return playerRegionId;
	}

	public void setPlayerRegionId(int playerRegionId)
	{
		this.playerRegionId = playerRegionId;
	}

	public String getPlayerRegionIsoCodeLong()
	{
		return playerRegionIsoCodeLong;
	}

	public void setPlayerRegionIsoCodeLong(String playerRegionIsoCodeLong)
	{
		this.playerRegionIsoCodeLong = playerRegionIsoCodeLong;
	}

	public int getFavouriteTeam()
	{
		return favouriteTeam;
	}

	public void setFavouriteTeam(int favouriteTeam)
	{
		this.favouriteTeam = favouriteTeam;
	}

	public String getJoinedTIme()
	{
		return joinedTime;
	}

	public void setJoinedTime(String joinedTIme)
	{
		this.joinedTime = joinedTIme;
	}

	public int getStartedEvent()
	{
		return startedEvent;
	}

	public void setStartedEvent(int startedEvent)
	{
		this.startedEvent = startedEvent;
	}

	public int getCurrentEvent()
	{
		return currentEvent;
	}

	public void setCurrentEvent(int currentEvent)
	{
		this.currentEvent = currentEvent;
	}

	public JsonUserLeagues[] getLeagues()
	{
		return leagues;
	}

	public void setLeagues(JsonUserLeagues[] leagues)
	{
		this.leagues = leagues;
	}

	public boolean isNameChangeBlocked()
	{
		return nameChangeBlocked;
	}

	public void setNameChangeBlocked(boolean nameChangeBlocked)
	{
		this.nameChangeBlocked = nameChangeBlocked;
	}

	public String getKit()
	{
		return kit;
	}

	public void setKit(String kit)
	{
		this.kit = kit;
	}
}
