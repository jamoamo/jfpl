/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the So Аftware without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
			  throws XClientException
	{
		checkExceptions();
		return data;
	}

	private void checkExceptions()
			  throws JsonSyntaxException, XConnectionException
	{
		if(throwIOException)
		{
			throw new XConnectionException(new IOException());
		}
		else if(throwAPIException)
		{
			throw new XResponseMappingException(new JsonSyntaxException("Syntax exception"));
		}
	}

	@Override
	public List<JsonFixture> getFixtures()
			  throws XClientException
	{
		checkExceptions();
		return fixtures;
	}

	@Override
	public List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws XClientException
	{
		return fixtures.stream().filter(f -> f.getEvent() == gameweekNr).collect(Collectors.toList());
	}

	@Override
	public JsonCurrentUser getCurrentUser()
			  throws XClientException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public JsonUser getUser(int id)
			  throws XClientException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean login(FPLLoginCredentials creds)
			  throws XClientException
	{
		return true;
	}
	
	@Override
	public boolean isLoggedIn()
	{
		return true;
	}

	@Override
	public JsonCurrentUserTeam getCurrentUserTeam(int id)
			  throws XClientException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public JsonUserHistory getUserHistory(int id)
			  throws XClientException
	{
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public JsonEntryGameweek getEntryGameweek(int entity, int event)
			  throws XClientException
	{
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
}
