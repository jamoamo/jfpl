/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLTeam;

/**
 *
 * @author James Amoore
 */
class TeamMapper
{
	protected FPLTeam mapTeam(JsonTeam jsonTeam)
	{
		//why are tests skipped?
		FPLTeam team = new FPLTeam(jsonTeam.getId(), jsonTeam.getName(), jsonTeam.getShortName());
		return team;
	}
}
