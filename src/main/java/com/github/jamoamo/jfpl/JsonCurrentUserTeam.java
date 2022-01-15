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
class JsonCurrentUserTeam
{
	private JsonTeamPicks[] picks;

	private JsonTeamChip[] chips;

	private JsonTeamTransfers transfers;

	public JsonTeamPicks[] getPicks()
	{
		return picks;
	}

	public void setPicks(JsonTeamPicks[] picks)
	{
		this.picks = picks;
	}

	public JsonTeamChip[] getChips()
	{
		return chips;
	}

	public void setChips(JsonTeamChip[] chips)
	{
		this.chips = chips;
	}

	public JsonTeamTransfers getTransfers()
	{
		return transfers;
	}

	public void setTransfers(JsonTeamTransfers transfers)
	{
		this.transfers = transfers;
	}
}
