/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
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
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author James Amoore
 */
class UserTeamMapper
{
	private static final double FACTOR_OF_TEN = 10.0;
	private static final String MSG_SUFFIX_IN_TEAM = " in team.";

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
		return findUniquePick(team, p -> p.isIsCaptain(), playerMap, "captain");
	}

	private FPLPlayer mapViceCaptain(JsonCurrentUserTeam team, Map<Integer, FPLPlayer> playerMap)
			  throws XFPLMappingException
	{
		return findUniquePick(team, p -> p.isIsViceCaptain(), playerMap, "vice captain");
	}

	private FPLPlayer findUniquePick(JsonCurrentUserTeam team, Predicate<JsonTeamPicks> matcher,
			  Map<Integer, FPLPlayer> playerMap, String roleName)
			  throws XFPLMappingException
	{
		List<JsonTeamPicks> matches = Arrays.stream(team.getPicks())
				  .filter(matcher).collect(Collectors.toList());
		if(matches.isEmpty())
		{
			throw new XFPLMappingException("No " + roleName + MSG_SUFFIX_IN_TEAM);
		}
		if(matches.size() > 1)
		{
			throw new XFPLMappingException("More than one " + roleName + MSG_SUFFIX_IN_TEAM);
		}
		return playerMap.get(matches.get(0).getElement());
	}

	private List<FPLUserTeamPick> mapPicks(JsonTeamPicks[] jsonPicks, Map<Integer, FPLPlayer> playerMap)
	{
		return Arrays.stream(jsonPicks)
				  .map(pick -> mapPick(pick, playerMap))
				  .collect(Collectors.toList());
	}

	private static FPLUserTeamPick mapPick(JsonTeamPicks pick, Map<Integer, FPLPlayer> playerMap)
	{
		return new FPLUserTeamPick(
				  pick.getPosition(),
				  playerMap.get(pick.getElement()), pick.getSellingPrice() / FACTOR_OF_TEN,
				  pick.getPurchasePrice() / FACTOR_OF_TEN);
	}

	private List<FPLTeamChip> mapChips(JsonTeamChip[] chips)
	{
		return Arrays.stream(chips)
				  .map(chip ->
							 new FPLTeamChip(mapChip(chip.getName()),
												  mapChipStatus(chip.getStatusForEntry()),
												  Arrays.stream(chip.getPlayedByEntry()).boxed().toArray(Integer[]::new),
												  chip.getNumber(),
												  chip.getStartEvent(),
												  chip.getStopEvent())
				  ).collect(Collectors.toList());
	}

	// The string literals below are the exact values returned by the undocumented FPL API's chip "name"
	// field, discovered by observation rather than published documentation. FPL has added chip types
	// over time, so this switch (and the FPLChip enum) may need a new case if a new chip is introduced.
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
		else
		{
			switch(statusForEntry)
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
}
