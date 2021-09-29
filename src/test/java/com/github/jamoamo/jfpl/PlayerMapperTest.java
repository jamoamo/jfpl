/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLPosition;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class PlayerMapperTest
{
	/**
	 * Test of mapPlayer method, of class PlayerMapper.
	 */
	@Test
	public void testMapPlayer_Midfielder()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("Bruno");
		jsonPlayer.setSecondName("Fernandes");
		jsonPlayer.setElementType(3);
		jsonPlayer.setTeam(13);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertEquals(jsonPlayer.getId(), result.getId());
		assertEquals(jsonPlayer.getFirstName(), result.getFirstName());
		assertEquals(jsonPlayer.getSecondName(), result.getLastName());
		assertEquals(jsonPlayer.getTeam(), result.getTeam().getId());
		assertEquals(FPLPosition.MIDFIELDER, result.getPosition());
	}
	
	@Test
	public void testMapPlayer_Forward()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("Edison");
		jsonPlayer.setSecondName("Cavani");
		jsonPlayer.setElementType(4);
		jsonPlayer.setTeam(13);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertEquals(jsonPlayer.getId(), result.getId());
		assertEquals(jsonPlayer.getFirstName(), result.getFirstName());
		assertEquals(jsonPlayer.getSecondName(), result.getLastName());
		assertEquals(jsonPlayer.getTeam(), result.getTeam().getId());
		assertEquals(FPLPosition.FORWARD, result.getPosition());
	}
	
	@Test
	public void testMapPlayer_Defender()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("Harry");
		jsonPlayer.setSecondName("Maguire");
		jsonPlayer.setElementType(2);
		jsonPlayer.setTeam(13);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertEquals(jsonPlayer.getId(), result.getId());
		assertEquals(jsonPlayer.getFirstName(), result.getFirstName());
		assertEquals(jsonPlayer.getSecondName(), result.getLastName());
		assertEquals(jsonPlayer.getTeam(), result.getTeam().getId());
		assertEquals(FPLPosition.DEFENDER, result.getPosition());
	}
	
	@Test
	public void testMapPlayer_Goalkeeper()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("David");
		jsonPlayer.setSecondName("de Gea");
		jsonPlayer.setElementType(1);
		jsonPlayer.setTeam(13);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertEquals(jsonPlayer.getId(), result.getId());
		assertEquals(jsonPlayer.getFirstName(), result.getFirstName());
		assertEquals(jsonPlayer.getSecondName(), result.getLastName());
		assertEquals(jsonPlayer.getTeam(), result.getTeam().getId());
		assertEquals(FPLPosition.GOALKEEPER, result.getPosition());
	}
	
	@Test
	public void testMapPlayer_playingChance()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("David");
		jsonPlayer.setSecondName("de Gea");
		jsonPlayer.setElementType(1);
		jsonPlayer.setTeam(13);
		jsonPlayer.setChanceOfPlayingNextRound(100);
		jsonPlayer.setChanceOfPlayingThisRound(75);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertNotNull(result.getPlayingChance());
		assertEquals(100, result.getPlayingChance().getChanceNextRound());
		assertEquals(75, result.getPlayingChance().getChanceThisRound());
	}
	
	@Test
	public void testMapPlayer_playingTransfers()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("David");
		jsonPlayer.setSecondName("de Gea");
		jsonPlayer.setElementType(1);
		jsonPlayer.setTeam(13);
		jsonPlayer.setTransfersIn(1000);
		jsonPlayer.setTransfersInEvent(105);
		jsonPlayer.setTransfersOut(120);
		jsonPlayer.setTransfersOutEvent(52);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertNotNull(result.getTransfers());
		assertEquals(1000, result.getTransfers().getTransfersIn());
		assertEquals(105, result.getTransfers().getTransfersInEvent());
		assertEquals(120, result.getTransfers().getTransfersOut());
		assertEquals(52, result.getTransfers().getTransfersOutEvent());
	}
	
	@Test
	public void testMapPlayer_ict()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("David");
		jsonPlayer.setSecondName("de Gea");
		jsonPlayer.setElementType(1);
		jsonPlayer.setTeam(13);
		jsonPlayer.setInfluence(1.3);
		jsonPlayer.setInfluenceRank(123);
		jsonPlayer.setInfluenceRankType(10);
		jsonPlayer.setCreativity(2.3);
		jsonPlayer.setCreativityRank(223);
		jsonPlayer.setCreativityRankType(1);
		jsonPlayer.setThreat(203.4);
		jsonPlayer.setThreatRank(1456);
		jsonPlayer.setThreatRankType(17);
		jsonPlayer.setIctIndex(23.4);
		jsonPlayer.setIctIndexRank(3);
		jsonPlayer.setIctIndexRankType(11);
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertNotNull(result.getIct());
		assertEquals(1.3, result.getIct().getInfluence());
		assertEquals(123, result.getIct().getInfluenceRank());
		assertEquals(10, result.getIct().getInfluenceRankType());
		assertEquals(2.3, result.getIct().getCreativity());
		assertEquals(223, result.getIct().getCreativityRank());
		assertEquals(1, result.getIct().getCreativityRankType());
		assertEquals(203.4, result.getIct().getThreat());
		assertEquals(1456, result.getIct().getThreatRank());
		assertEquals(17, result.getIct().getThreatRankType());
		assertEquals(23.4, result.getIct().getIctIndex());
		assertEquals(3, result.getIct().getIctIndexRank());
		assertEquals(11, result.getIct().getIctIndexRankType());
	}
	
	@Test
	public void testMapPlayer_stats()
	{
		JsonPlayer jsonPlayer = new JsonPlayer();
		jsonPlayer.setId(111);
		jsonPlayer.setFirstName("David");
		jsonPlayer.setSecondName("de Gea");
		jsonPlayer.setElementType(1);
		jsonPlayer.setTeam(13);
		jsonPlayer.setForm(4.0);
		jsonPlayer.setPointsPerGame(3.5);
		jsonPlayer.setSelectedByPercent(15.2);
		jsonPlayer.setTotalPoints(365);
		jsonPlayer.setValueForm(0.9);
		jsonPlayer.setValueSeason(0.6);
		jsonPlayer.setNowCost(40);
		jsonPlayer.setMinutes(500);
		jsonPlayer.setGoalsScored(1);
		jsonPlayer.setAssists(2);
		jsonPlayer.setCleanSheets(3);
		jsonPlayer.setGoalsConceeded(4);
		jsonPlayer.setOwnGoals(5);
		jsonPlayer.setPenaltiesSaved(6);
		jsonPlayer.setPenaltiesMissed(7);
		jsonPlayer.setYellowCards(8);
		jsonPlayer.setRedCards(9);
		jsonPlayer.setSaves(10);
		jsonPlayer.setBonus(11);
		jsonPlayer.setBps(12);
		
		Map<Integer, FPLTeam> teamMap = new HashMap<>();
		teamMap.put(13,new FPLTeam(13,"Man Utd","MUN"));
		teamMap.put(12,new FPLTeam(12,"Man City","MCI"));
		PlayerMapper instance = new PlayerMapper();
		FPLPlayer result = instance.mapPlayer(jsonPlayer, teamMap);
		assertNotNull(result.getStats());
		assertEquals(4.0, result.getStats().getForm());
		assertEquals(3.5, result.getStats().getPointsPerGame());
		assertEquals(15.2, result.getStats().getSelectedBy());
		assertEquals(365, result.getStats().getTotalPoints());
		assertEquals(0.9, result.getStats().getValueForm());
		assertEquals(0.6, result.getStats().getValueSeason());
		assertEquals(4.0, result.getStats().getCost());
		assertEquals(500, result.getStats().getMinutes());
		assertEquals(1, result.getStats().getGoalsScored());
		assertEquals(2, result.getStats().getAssists());
		assertEquals(3, result.getStats().getCleanSheets());
		assertEquals(4, result.getStats().getGoalsConceded());
		assertEquals(5, result.getStats().getOwnGoals());
		assertEquals(6, result.getStats().getPenaltiesSaved());
		assertEquals(7, result.getStats().getPenaltiesMissed());
		assertEquals(8, result.getStats().getYellowCards());
		assertEquals(9, result.getStats().getRedCards());
		assertEquals(10, result.getStats().getSaves());
		assertEquals(11, result.getStats().getBonus());
		assertEquals(12, result.getStats().getBps());
	}
}
