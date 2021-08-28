/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLUser;

/**
 *
 * @author James Amoore
 */
public class UserMapper
{
	protected FPLUser mapUser(JsonUser user)
	{
		return new FPLUser(
				  user.getId(),
				  user.getName(),
				  user.getPlayerFirstName(),
				  user.getPlayerLastName(),
				  null,
				  user.getPlayerRegionName()
		);
	}
}
