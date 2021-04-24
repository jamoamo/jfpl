/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLPlayer;
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
		FPLPlayer player = new FPLPlayer(
				  jsonPlayer.getId(), 
				  jsonPlayer.getFirstName(), 
				  jsonPlayer.getSecondName(), 
				  teamMap.get(jsonPlayer.getTeam()), 
				  FPLPosition.values()[jsonPlayer.getElementType() -1]);
		return player;
	}
}
