/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Maps a fixture from the one returned from the FPL JSON API to one exposed by this library.
 * 
 * @author James Amoore
 */
public class FixtureMapper
{
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	protected FPLFixture mapFixture(JsonFixture jsonFixture, Map<Integer, FPLTeam> teamMap)
	{
		FPLTeam homeTeam = teamMap.get(jsonFixture.getTeamH());
		FPLTeam awayTeam = teamMap.get(jsonFixture.getTeamA());
		LocalDateTime kickoff = null;
		if(jsonFixture.getKickoffTime() != null)
		{
			kickoff = LocalDateTime.parse(jsonFixture.getKickoffTime(), FORMATTER);
		}
		return new FPLFixture(jsonFixture.getId(), jsonFixture.getEvent(), kickoff, homeTeam, awayTeam);
	}
}
