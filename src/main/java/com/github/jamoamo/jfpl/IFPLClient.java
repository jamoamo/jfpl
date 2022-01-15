/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import java.io.IOException;
import java.util.List;

interface IFPLClient
{
	boolean login(FPLLoginCredentials creds)
			  throws IOException;

	JsonCurrentUser getCurrentUser()
			  throws IOException;

	JsonCurrentUserTeam getCurrentUserTeam(int id)
			  throws IOException;

	JsonUser getUser(int id)
			  throws IOException;

	JsonStaticData getStaticData()
			  throws IOException;

	List<JsonFixture> getFixtures()
			  throws IOException;

	List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws IOException;

	JsonUserHistory getUserHistory(int id)
			  throws IOException;
}
