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
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLPlayerICT;
import com.github.jamoamo.jfpl.model.FPLPlayerSetPieces;
import com.github.jamoamo.jfpl.model.FPLPlayerStats;
import com.github.jamoamo.jfpl.model.FPLPlayerTransfers;
import com.github.jamoamo.jfpl.model.FPLPlayingChance;
import com.github.jamoamo.jfpl.model.FPLPosition;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.util.Map;

/**
 * Maps a player from the one returned from the FPL JSON API to one exposed by this library.
 *
 * @author James Amoore
 */
class PlayerMapper
{
	private static final double FACTOR_OF_TEN = 10.0;
	private static final int FULL_CHANCE = 100;

	protected FPLPlayer mapPlayer(JsonPlayer jsonPlayer, Map<Integer, FPLTeam> teamMap)
	{
		FPLPlayingChance playingChance = mapPlayingChance(jsonPlayer);

		FPLPlayerStats playerStats = mapPlayerStats(jsonPlayer);

		FPLPlayerTransfers transfers = mapTransfers(jsonPlayer);

		FPLPlayerICT ict = mapICT(jsonPlayer);

		FPLPlayerSetPieces setPieces = mapSetPieces(jsonPlayer);

		FPLPosition position = mapFPLPosition(jsonPlayer);

		FPLPlayer player = new FPLPlayer(
				  jsonPlayer.getId(),
				  jsonPlayer.getFirstName(),
				  jsonPlayer.getSecondName(),
				  jsonPlayer.getWebName(),
				  teamMap.get(jsonPlayer.getTeam()),
				  position,
				  playingChance,
				  playerStats,
				  transfers,
				  ict,
				  setPieces);

		return player;
	}

	private FPLPlayingChance mapPlayingChance(JsonPlayer player)
	{
		FPLPlayingChance playingChance = new FPLPlayingChance(
				  player.getChanceOfPlayingThisRound() == null ? FULL_CHANCE : player.getChanceOfPlayingThisRound(),
				  player.getChanceOfPlayingNextRound() == null ? FULL_CHANCE : player.getChanceOfPlayingNextRound());
		return playingChance;
	}

	private FPLPlayerSetPieces mapSetPieces(JsonPlayer jsonPlayer)
	{
		FPLPlayerSetPieces setPieces = new FPLPlayerSetPieces(
				  jsonPlayer.getCornersAndIndirectFreekicksOrder(),
				  jsonPlayer.getDirectFreekicksOrder(),
				  jsonPlayer.getPenaltiesOrder());
		return setPieces;
	}

	private FPLPlayerTransfers mapTransfers(JsonPlayer jsonPlayer)
	{
		FPLPlayerTransfers transfers = new FPLPlayerTransfers(
				  jsonPlayer.getTransfersIn(),
				  jsonPlayer.getTransfersInEvent(),
				  jsonPlayer.getTransfersOut(),
				  jsonPlayer.getTransfersOutEvent());
		return transfers;
	}

	private FPLPlayerICT mapICT(JsonPlayer jsonPlayer)
	{
		FPLPlayerICT ict = new FPLPlayerICT(
				  jsonPlayer.getInfluence(),
				  jsonPlayer.getInfluenceRank(),
				  jsonPlayer.getInfluenceRankType(),
				  jsonPlayer.getCreativity(),
				  jsonPlayer.getCreativityRank(),
				  jsonPlayer.getCreativityRankType(),
				  jsonPlayer.getThreat(),
				  jsonPlayer.getThreatRank(),
				  jsonPlayer.getThreatRankType(),
				  jsonPlayer.getIctIndex(),
				  jsonPlayer.getIctIndexRank(),
				  jsonPlayer.getIctIndexRankType());
		return ict;
	}

	private FPLPlayerStats mapPlayerStats(JsonPlayer jsonPlayer)
	{
		FPLPlayerStats playerStats = new FPLPlayerStats(
				  jsonPlayer.getForm(),
				  jsonPlayer.getPointsPerGame(),
				  jsonPlayer.getSelectedByPercent(),
				  jsonPlayer.getTotalPoints(),
				  jsonPlayer.getValueForm(),
				  jsonPlayer.getValueSeason(),
				  jsonPlayer.getNowCost() / FACTOR_OF_TEN,
				  jsonPlayer.getMinutes(),
				  jsonPlayer.getGoalsScored(),
				  jsonPlayer.getAssists(),
				  jsonPlayer.getCleanSheets(),
				  jsonPlayer.getGoalsConceeded(),
				  jsonPlayer.getOwnGoals(),
				  jsonPlayer.getPenaltiesSaved(),
				  jsonPlayer.getPenaltiesMissed(),
				  jsonPlayer.getYellowCards(),
				  jsonPlayer.getRedCards(),
				  jsonPlayer.getSaves(),
				  jsonPlayer.getBonus(),
				  jsonPlayer.getBps());
		return playerStats;
	}

	private FPLPosition mapFPLPosition(JsonPlayer jsonPlayer)
	{
		int jsonPlayerType = jsonPlayer.getElementType();
		return FPLPosition.values()[jsonPlayerType - 1];
	}
}
