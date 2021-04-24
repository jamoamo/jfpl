/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLTeam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author James Amoore
 */
public class TeamMapperTest
{
	
	public TeamMapperTest()
	{
	}

	/**
	 * Test of mapTeam method, of class TeamMapper.
	 */
	@Test
	public void testMapTeam()
	{
		System.out.println("mapTeam");
		JsonTeam jsonTeam = new JsonTeam();
		jsonTeam.setId(13);
		jsonTeam.setName("Man Utd");
		jsonTeam.setShortName("MUN");
		TeamMapper instance = new TeamMapper();
		FPLTeam team = instance.mapTeam(jsonTeam);
		assertEquals(jsonTeam.getId(), team.getId());
		assertEquals(jsonTeam.getName(), team.getName());
		assertEquals(jsonTeam.getShortName(), team.getShortName());
	}
	
}
