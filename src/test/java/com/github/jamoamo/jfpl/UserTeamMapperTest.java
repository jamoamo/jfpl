/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLChip;
import com.github.jamoamo.jfpl.model.FPLChipStatus;
import com.github.jamoamo.jfpl.model.FPLPlayer;
import com.github.jamoamo.jfpl.model.FPLUserTeam;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class UserTeamMapperTest
{
	/**
	 * Test of mapUserTeam method, of class UserTeamMapper.
	 */
	@Test
	public void testMapUserTeam()
	{
		JsonCurrentUserTeam team = new JsonCurrentUserTeam();
		JsonTeamChip[] chips = new JsonTeamChip[4];
		chips[0] = new JsonTeamChip();
		chips[0].setChipType("transfer");
		chips[0].setName("wildcard");
		chips[0].setNumber(1);
		chips[0].setPlayedByEntry(new int[]{2,28});
		chips[0].setStartEvent(2);
		chips[0].setStopEvent(20);
		chips[0].setStatusForEntry("active");
		
		chips[1] = new JsonTeamChip();
		chips[1].setChipType("transfer");
		chips[1].setName("freehit");
		chips[1].setNumber(1);
		chips[1].setPlayedByEntry(new int[]{});
		chips[1].setStartEvent(2);
		chips[1].setStopEvent(38);
		chips[1].setStatusForEntry("unavailable");
		
		chips[2] = new JsonTeamChip();
		chips[2].setChipType("team");
		chips[2].setName("bboost");
		chips[2].setNumber(1);
		chips[2].setPlayedByEntry(new int[]{13});
		chips[2].setStartEvent(1);
		chips[2].setStopEvent(38);
		chips[2].setStatusForEntry("available");
		
		chips[3] = new JsonTeamChip();
		chips[3].setChipType("team");
		chips[3].setName("3xc");
		chips[3].setNumber(1);
		chips[3].setPlayedByEntry(new int[]{});
		chips[3].setStartEvent(1);
		chips[3].setStopEvent(38);
		chips[3].setStatusForEntry("available");
		
		JsonTeamPick[] picks = new JsonTeamPick[15];
		picks[0] = new JsonTeamPick();
		picks[0].setElementId(1);
		picks[0].setIsCaptain(false);
		picks[0].setIsViceCaptain(false);
		picks[0].setMultiplier(1);
		picks[0].setPosition(1);
		picks[0].setPurchasingPrice(56);
		picks[0].setSellingPrice(57);
		
		picks[1] = new JsonTeamPick();
		picks[1].setElementId(2);
		picks[1].setIsCaptain(false);
		picks[1].setIsViceCaptain(false);
		picks[1].setMultiplier(1);
		picks[1].setPosition(2);
		picks[1].setPurchasingPrice(56);
		picks[1].setSellingPrice(57);
		
		picks[2] = new JsonTeamPick();
		picks[2].setElementId(3);
		picks[2].setIsCaptain(false);
		picks[2].setIsViceCaptain(false);
		picks[2].setMultiplier(1);
		picks[2].setPosition(3);
		picks[2].setPurchasingPrice(56);
		picks[2].setSellingPrice(57);
		
		picks[3] = new JsonTeamPick();
		picks[3].setElementId(4);
		picks[3].setIsCaptain(false);
		picks[3].setIsViceCaptain(false);
		picks[3].setMultiplier(1);
		picks[3].setPosition(4);
		picks[3].setPurchasingPrice(56);
		picks[3].setSellingPrice(57);
		
		picks[4] = new JsonTeamPick();
		picks[4].setElementId(5);
		picks[4].setIsCaptain(false);
		picks[4].setIsViceCaptain(false);
		picks[4].setMultiplier(1);
		picks[4].setPosition(5);
		picks[4].setPurchasingPrice(56);
		picks[4].setSellingPrice(57);
		
		picks[5] = new JsonTeamPick();
		picks[5].setElementId(6);
		picks[5].setIsCaptain(false);
		picks[5].setIsViceCaptain(false);
		picks[5].setMultiplier(1);
		picks[5].setPosition(6);
		picks[5].setPurchasingPrice(56);
		picks[5].setSellingPrice(57);
		
		picks[6] = new JsonTeamPick();
		picks[6].setElementId(7);
		picks[6].setIsCaptain(false);
		picks[6].setIsViceCaptain(false);
		picks[6].setMultiplier(1);
		picks[6].setPosition(7);
		picks[6].setPurchasingPrice(56);
		picks[6].setSellingPrice(57);
		
		picks[7] = new JsonTeamPick();
		picks[7].setElementId(8);
		picks[7].setIsCaptain(true);
		picks[7].setIsViceCaptain(false);
		picks[7].setMultiplier(2);
		picks[7].setPosition(8);
		picks[7].setPurchasingPrice(56);
		picks[7].setSellingPrice(57);
		
		picks[8] = new JsonTeamPick();
		picks[8].setElementId(9);
		picks[8].setIsCaptain(false);
		picks[8].setIsViceCaptain(false);
		picks[8].setMultiplier(1);
		picks[8].setPosition(9);
		picks[8].setPurchasingPrice(56);
		picks[8].setSellingPrice(57);
		
		picks[9] = new JsonTeamPick();
		picks[9].setElementId(10);
		picks[9].setIsCaptain(false);
		picks[9].setIsViceCaptain(false);
		picks[9].setMultiplier(1);
		picks[9].setPosition(10);
		picks[9].setPurchasingPrice(56);
		picks[9].setSellingPrice(57);
		
		picks[10] = new JsonTeamPick();
		picks[10].setElementId(11);
		picks[10].setIsCaptain(false);
		picks[10].setIsViceCaptain(true);
		picks[10].setMultiplier(1);
		picks[10].setPosition(11);
		picks[10].setPurchasingPrice(56);
		picks[10].setSellingPrice(57);
		
		picks[11] = new JsonTeamPick();
		picks[11].setElementId(12);
		picks[11].setIsCaptain(false);
		picks[11].setIsViceCaptain(false);
		picks[11].setMultiplier(1);
		picks[11].setPosition(12);
		picks[11].setPurchasingPrice(56);
		picks[11].setSellingPrice(57);
		
		picks[12] = new JsonTeamPick();
		picks[12].setElementId(13);
		picks[12].setIsCaptain(false);
		picks[12].setIsViceCaptain(false);
		picks[12].setMultiplier(1);
		picks[12].setPosition(13);
		picks[12].setPurchasingPrice(56);
		picks[12].setSellingPrice(57);
		
		picks[13] = new JsonTeamPick();
		picks[13].setElementId(14);
		picks[13].setIsCaptain(false);
		picks[13].setIsViceCaptain(false);
		picks[13].setMultiplier(1);
		picks[13].setPosition(14);
		picks[13].setPurchasingPrice(56);
		picks[13].setSellingPrice(57);
		
		picks[14] = new JsonTeamPick();
		picks[14].setElementId(15);
		picks[14].setIsCaptain(false);
		picks[14].setIsViceCaptain(false);
		picks[14].setMultiplier(1);
		picks[14].setPosition(15);
		picks[14].setPurchasingPrice(56);
		picks[14].setSellingPrice(57);
		
		team.setChips(chips);
		team.setPicks(picks);
		
		Map<Integer, FPLPlayer> playerMap = new HashMap<>();
		playerMap.put(1, new FPLPlayer(1, "Player", "One", "One", null, null, null, null, null, null, null));
		playerMap.put(2, new FPLPlayer(2, "Player", "Two", "Two", null, null, null, null, null, null, null));
		playerMap.put(3, new FPLPlayer(3, "Player", "Three", "Three", null, null, null, null, null, null, null));
		playerMap.put(4, new FPLPlayer(4, "Player", "Four", "Four", null, null, null, null, null, null, null));
		playerMap.put(5, new FPLPlayer(5, "Player", "Five", "Five", null, null, null, null, null, null, null));
		playerMap.put(6, new FPLPlayer(6, "Player", "Six", "Six", null, null, null, null, null, null, null));
		playerMap.put(7, new FPLPlayer(7, "Player", "Seven", "Seven", null, null, null, null, null, null, null));
		playerMap.put(8, new FPLPlayer(8, "Player", "Eight", "Eight", null, null, null, null, null, null, null));
		playerMap.put(9, new FPLPlayer(9, "Player", "Nine", "Nine", null, null, null, null, null, null, null));
		playerMap.put(10, new FPLPlayer(10, "Player", "Ten", "Ten", null, null, null, null, null, null, null));
		playerMap.put(11, new FPLPlayer(11, "Player", "Eleven", "Eleven", null, null, null, null, null, null, null));
		playerMap.put(12, new FPLPlayer(12, "Player", "Twelve", "Twelve", null, null, null, null, null, null, null));
		playerMap.put(13, new FPLPlayer(13, "Player", "Thirteen", "Thirteen", null, null, null, null, null, null, null));
		playerMap.put(14, new FPLPlayer(14, "Player", "Fourteen", "Fourteen", null, null, null, null, null, null, null));
		playerMap.put(15, new FPLPlayer(15, "Player", "Fifteen", "Fifteen", null, null, null, null, null, null, null));
		UserTeamMapper instance = new UserTeamMapper();
		FPLUserTeam result = instance.mapUserTeam(team, playerMap);
		assertEquals("One", result.getStarting11().get(0).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(0).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(0).getSellingPrice());
		assertEquals("Two", result.getStarting11().get(1).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(1).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(1).getSellingPrice());
		assertEquals("Three", result.getStarting11().get(2).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(2).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(2).getSellingPrice());
		assertEquals("Four", result.getStarting11().get(3).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(3).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(3).getSellingPrice());
		assertEquals("Five", result.getStarting11().get(4).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(4).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(4).getSellingPrice());
		assertEquals("Six", result.getStarting11().get(5).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(5).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(5).getSellingPrice());
		assertEquals("Seven", result.getStarting11().get(6).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(6).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(6).getSellingPrice());
		assertEquals("Eight", result.getStarting11().get(7).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(7).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(7).getSellingPrice());
		assertEquals("Nine", result.getStarting11().get(8).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(8).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(8).getSellingPrice());
		assertEquals("Ten", result.getStarting11().get(9).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(9).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(9).getSellingPrice());
		assertEquals("Eleven", result.getStarting11().get(10).getPlayer().getLastName());
		assertEquals(56, result.getStarting11().get(10).getPurchasingPrice());
		assertEquals(57, result.getStarting11().get(10).getSellingPrice());
		assertEquals("Twelve", result.getBench().get(0).getPlayer().getLastName());
		assertEquals(56, result.getBench().get(0).getPurchasingPrice());
		assertEquals(57, result.getBench().get(0).getSellingPrice());
		assertEquals("Thirteen", result.getBench().get(1).getPlayer().getLastName());
		assertEquals(56, result.getBench().get(1).getPurchasingPrice());
		assertEquals(57, result.getBench().get(1).getSellingPrice());
		assertEquals("Fourteen", result.getBench().get(2).getPlayer().getLastName());
		assertEquals(56, result.getBench().get(2).getPurchasingPrice());
		assertEquals(57, result.getBench().get(2).getSellingPrice());
		assertEquals("Fifteen", result.getBench().get(3).getPlayer().getLastName());
		assertEquals(56, result.getBench().get(3).getPurchasingPrice());
		assertEquals(57, result.getBench().get(3).getSellingPrice());
		assertEquals("Eight", result.getCaptain().getLastName());
		assertEquals("Eleven", result.getViceCaptain().getLastName());
		assertEquals(FPLChip.WILDCARD, result.getChips().get(0).getChip());
		assertEquals(FPLChipStatus.ACTIVE, result.getChips().get(0).getStatus());
		assertEquals(FPLChip.FREEHIT, result.getChips().get(1).getChip());
		assertEquals(FPLChipStatus.UNAVAILABLE, result.getChips().get(1).getStatus());
		assertEquals(FPLChip.BENCH_BOOST, result.getChips().get(2).getChip());
		assertEquals(FPLChipStatus.AVAILABLE, result.getChips().get(2).getStatus());
		assertEquals(FPLChip.TRIPLE_CAPTAIN, result.getChips().get(3).getChip());
		assertEquals(FPLChipStatus.AVAILABLE, result.getChips().get(3).getStatus());
	}
	
	public void testMapChip_wildcard()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChip chip = mapper.mapChip("wildcard");
		assertEquals(FPLChip.WILDCARD, chip);
	}
	
	public void testMapChip_freehit()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChip chip = mapper.mapChip("freehit");
		assertEquals(FPLChip.FREEHIT, chip);
	}
	
	public void testMapChip_bboost()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChip chip = mapper.mapChip("bboost");
		assertEquals(FPLChip.BENCH_BOOST, chip);
	}
	
	public void testMapChip_3xc()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChip chip = mapper.mapChip("3xc");
		assertEquals(FPLChip.TRIPLE_CAPTAIN, chip);
	}
	
	public void testMapChip_null()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		Assertions.assertThrows(XFPLMappingException.class, () -> mapper.mapChip(null));
	}
	
	public void testMapChip_unknown()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		Assertions.assertThrows(XFPLMappingException.class, () -> mapper.mapChip("unknown"));
	}
	
	public void testMapChipStatus_available()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChipStatus chipStatus = mapper.mapChipStatus("available");
		assertEquals(FPLChipStatus.AVAILABLE, chipStatus);
	}
	
	public void testMapChipStatus_active()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChipStatus chipStatus = mapper.mapChipStatus("active");
		assertEquals(FPLChipStatus.ACTIVE, chipStatus);
	}
	
	public void testMapChipStatus_unavailable()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		FPLChipStatus chipStatus = mapper.mapChipStatus("unavailable");
		assertEquals(FPLChipStatus.UNAVAILABLE, chipStatus);
	}
	
	public void testMapChipStatus_null()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		Assertions.assertThrows(XFPLMappingException.class, () -> mapper.mapChipStatus(null));
	}
	
	public void testMapChipStatus_unknown()
	{
		UserTeamMapper mapper = new UserTeamMapper();
		
		Assertions.assertThrows(XFPLMappingException.class, () -> mapper.mapChipStatus("unknown"));
	}
	
}
