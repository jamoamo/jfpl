/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author James Amoore
 */
class TestClient implements IFPLClient
{
	JsonStaticData data = new JsonStaticData();
	List<JsonFixture> fixtures = new ArrayList<>();
	boolean throwIOException = false;
	boolean throwAPIException = false;
	
	@Override
	public JsonStaticData getStaticData()
			  throws IOException
	{
		if(throwIOException)
		{
			throw new IOException();
		}
		else if(throwAPIException)
		{
			throw new JsonSyntaxException("Syntax exception");
		}
		return data;
	}

	@Override
	public List<JsonFixture> getFixtures()
			  throws IOException
	{
		if(throwIOException)
		{
			throw new IOException();
		}
		else if(throwAPIException)
		{
			throw new JsonSyntaxException("Syntax exception");
		}
		return fixtures;
	}

	@Override
	public List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws IOException
	{
		return fixtures.stream().filter(f -> f.getEvent() == gameweekNr).collect(Collectors.toList());
	}

	@Override
	public JsonCurrentUser getCurrentUser()
			  throws IOException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public JsonUser getUser(int id)
			  throws IOException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean login(FPLLoginCredentials creds)
			  throws IOException
	{
		return true;
	}

	@Override
	public JsonCurrentUserTeam getCurrentUserTeam(int id)
			  throws IOException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public JsonUserHistory getUserHistory(int id)
			  throws IOException
	{
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
}
