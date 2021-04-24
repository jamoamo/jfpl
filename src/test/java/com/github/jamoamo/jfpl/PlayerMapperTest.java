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
	
	public PlayerMapperTest()
	{
	}

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
}
