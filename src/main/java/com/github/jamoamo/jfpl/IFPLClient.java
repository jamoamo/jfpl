/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author James Amoore
 */
interface IFPLClient
{
	public abstract void login(FPLLoginCredentials creds)
			  throws Exception;
	
	public abstract JsonCurrentUser getCurrentUser()
			  throws IOException;
	
	public abstract JsonUser getUser(int id)
			  throws IOException;
	
	public JsonStaticData getStaticData()
			  throws IOException;
	
	public List<JsonFixture> getFixtures()
			  throws IOException;
	
	public List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws IOException;
}
