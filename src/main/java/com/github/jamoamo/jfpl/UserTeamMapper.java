/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLChip;
import com.github.jamoamo.jfpl.model.FPLChipStatus;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLTeamChip;
import com.github.jamoamo.jfpl.model.FPLUserTeam;
import com.github.jamoamo.jfpl.model.FPLUserTeamPick;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author James Amoore
 */
class UserTeamMapper
{
	FPLUserTeam mapUserTeam(JsonCurrentUserTeam team, Map<Integer, FPLPlayer> playerMap)
	{
		List<FPLUserTeamPick> picks = mapPicks(team.getPicks(), playerMap);
		List<FPLTeamChip> chips = mapChips(team.getChips());
		
		FPLPlayer captain = mapCaptain(team, playerMap);
		
		FPLPlayer viceCaptain = mapViceCaptain(team, playerMap);
		
		FPLUserTeam userTeam = new FPLUserTeam(picks, chips, captain, viceCaptain);
		
		return userTeam;
	}

	private FPLPlayer mapCaptain(JsonCurrentUserTeam team, Map<Integer, FPLPlayer> playerMap)
			  throws XFPLMappingException
	{
		List<JsonTeamPick> captainList = Arrays.stream(team.getPicks())
				  .filter(p -> p.isIsCaptain()).collect(Collectors.toList());
		if(captainList.size() > 1)
		{
			throw new XFPLMappingException("More than one captain in team.");
		}
		FPLPlayer captain = playerMap.get(captainList.get(0).getElement());
		return captain;
	}

	private FPLPlayer mapViceCaptain(JsonCurrentUserTeam team, Map<Integer, FPLPlayer> playerMap)
			  throws XFPLMappingException
	{
		List<JsonTeamPick> viceCaptainList = Arrays.stream(team.getPicks())
				  .filter(p -> p.isIsViceCaptain()).collect(Collectors.toList());
		if(viceCaptainList.size() > 1)
		{
			throw new XFPLMappingException("More than one vice captain in team.");
		}
		FPLPlayer viceCaptain = playerMap.get(viceCaptainList.get(0).getElement());
		return viceCaptain;
	}

	private List<FPLUserTeamPick> mapPicks(JsonTeamPick[] jsonPicks, Map<Integer, FPLPlayer> playerMap)
	{
		return Arrays.stream(jsonPicks)
				  .map(pick -> mapPick(pick, playerMap))
				  .collect(Collectors.toList());
	}

	private static FPLUserTeamPick mapPick(JsonTeamPick pick, Map<Integer, FPLPlayer> playerMap)
	{
		return new FPLUserTeamPick(pick.getPosition(), playerMap.get(pick.getElement()), pick.getSellingPrice(), pick.getPurchasePrice());
	}

	private List<FPLTeamChip> mapChips(JsonTeamChip[] chips)
	{
		return Arrays.stream(chips)
				  .map(chip -> new FPLTeamChip(mapChip(chip.getName()), mapChipStatus(chip.getStatusForEntry()), Arrays.stream(chip.getPlayedByEntry()).boxed().toArray(Integer[]::new)))
				  .collect(Collectors.toList());
	}
	
	protected FPLChip mapChip(String chipName)
	{
		if(null == chipName)
		{
			throw new XFPLMappingException("Missing chip name");
		}
		switch(chipName)
		{
			case "wildcard":
				return FPLChip.WILDCARD;
			case "freehit":
				return FPLChip.FREEHIT;
			case "bboost":
				return FPLChip.BENCH_BOOST;
			case "3xc":
				return FPLChip.TRIPLE_CAPTAIN;
			default:
				throw new XFPLMappingException("Unknown chip: " + chipName);
		}
	}

	protected FPLChipStatus mapChipStatus(String statusForEntry)
	{
		if(null == statusForEntry)
		{
			throw new XFPLMappingException("Missing chip status");
		}
		else switch(statusForEntry)
		{
			case "active":
				return FPLChipStatus.ACTIVE;
			case "unavailable":
				return FPLChipStatus.UNAVAILABLE;
			case "available":
				return FPLChipStatus.AVAILABLE;
			case "played":
				return FPLChipStatus.PLAYED;
			default:
				throw new XFPLMappingException("Unknown chip status: " + statusForEntry);
		}
	}
}
