/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
	protected FPLPlayer mapPlayer(JsonPlayer jsonPlayer, Map<Integer,FPLTeam> teamMap)
	{
		FPLPlayingChance playingChance = mapPlayingChance(jsonPlayer);
		
		FPLPlayerStats playerStats = mapPlayerStats(jsonPlayer);
		
		FPLPlayerTransfers transfers = mapTransfers(jsonPlayer);
		
		FPLPlayerICT ict = mapICT(jsonPlayer);
		
		FPLPlayerSetPieces setPieces = mapSetPieces(jsonPlayer);
		
		FPLPlayer player = new FPLPlayer(
				  jsonPlayer.getId(), 
				  jsonPlayer.getFirstName(), 
				  jsonPlayer.getSecondName(), 
				  jsonPlayer.getWebName(),
				  teamMap.get(jsonPlayer.getTeam()), 
				  FPLPosition.values()[jsonPlayer.getElementType() -1],
				  playingChance,
				  playerStats,
				  transfers,
				  ict,
				  setPieces);
		
		return player;
	}

	private FPLPlayingChance mapPlayingChance(JsonPlayer jsonPlayer)
	{
		FPLPlayingChance playingChance = new FPLPlayingChance(jsonPlayer.getChanceOfPlayingThisRound(), jsonPlayer.getChanceOfPlayingNextRound());
		return playingChance;
	}

	private FPLPlayerSetPieces mapSetPieces(JsonPlayer jsonPlayer)
	{
		FPLPlayerSetPieces setPieces = new FPLPlayerSetPieces(jsonPlayer.getCornersAndIndirectFreekicksOrder(), jsonPlayer.getDirectFreekicksOrder(), jsonPlayer.getPenaltiesOrder());
		return setPieces;
	}

	private FPLPlayerTransfers mapTransfers(JsonPlayer jsonPlayer)
	{
		FPLPlayerTransfers transfers = new FPLPlayerTransfers(jsonPlayer.getTransfersIn(), jsonPlayer.getTransfersInEvent(), jsonPlayer.getTransfersOut(), jsonPlayer.getTransfersOutEvent());
		return transfers;
	}

	private FPLPlayerICT mapICT(JsonPlayer jsonPlayer)
	{
		FPLPlayerICT ict = new FPLPlayerICT(jsonPlayer.getInfluenceRank(), jsonPlayer.getInfluenceRankType(), jsonPlayer.getCreativityRank(),
				  jsonPlayer.getCreativityRankType(), jsonPlayer.getThreatRank(), jsonPlayer.getThreatRankType(), jsonPlayer.getIctIndexRank(),
				  jsonPlayer.getIctIndexRankType());
		return ict;
	}

	private FPLPlayerStats mapPlayerStats(JsonPlayer jsonPlayer)
	{
		FPLPlayerStats playerStats = new FPLPlayerStats(jsonPlayer.getForm(), jsonPlayer.getPointsPerGame(),
				  jsonPlayer.getSelectedByPercent(), jsonPlayer.getTotalPoints(), jsonPlayer.getValueForm(), jsonPlayer.getValueSeason(),
				  jsonPlayer.getNowCost(), jsonPlayer.getMinutes(), jsonPlayer.getGoalsScored(), jsonPlayer.getAssists(),
				  jsonPlayer.getCleanSheets(), jsonPlayer.getGoalsConceeded(), jsonPlayer.getOwnGoals(), jsonPlayer.getPenaltiesSaved(),
				  jsonPlayer.getPenaltiesMissed(), jsonPlayer.getYellowCards(), jsonPlayer.getRedCards(), jsonPlayer.getSaves(),
				  jsonPlayer.getBonus());
		return playerStats;
	}
}
