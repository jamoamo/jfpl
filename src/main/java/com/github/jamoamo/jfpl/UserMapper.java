/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLRegion;
import com.github.jamoamo.jfpl.model.FPLTeam;
import com.github.jamoamo.jfpl.model.FPLUser;
import java.util.Map;

/**
 *
 * @author James Amoore
 */
class UserMapper
{
	protected FPLUser mapUser(JsonUser user, Map<Integer, FPLTeam> team)
	{
		return new FPLUser(
				  user.getId(),
				  user.getName(),
				  user.getPlayerFirstName(),
				  user.getPlayerLastName(),
				  team.get(user.getFavouriteTeam()),
				  mapRegion(user)
		);
	}

	private FPLRegion mapRegion(JsonUser user)
	{
		FPLRegion region = new FPLRegion(user.getPlayerRegionId(), user.getPlayerRegionName(), user.getPlayerRegionIsoCodeLong(), user.getPlayerRegionIsoCodeShort());
		return region;
	}
}
