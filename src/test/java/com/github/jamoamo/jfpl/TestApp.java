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
public class TestApp
{
	public static void main(String[] args)
			  throws Exception
	{
		FPL fpl = new FPL();
		FPLLoginCredentials creds = new FPLLoginCredentials(args[0], args[1]);
		fpl.login(creds);
		FPLUser user = fpl.getCurrentUser();
		System.out.println(user.getTeamName());
		fpl.getPlayers();
	}
}
