/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
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
	JsonUser user;
	JsonUserHistory userHistory;
	JsonEntryGameweek entryGameweek;
	boolean throwIOException = false;
	boolean throwAPIException = false;
	boolean throwResourceNotFound = false;

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
		else if(throwResourceNotFound)
		{
			throw new XResourceNotFound();
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
		checkExceptions();
		return fixtures.stream().filter(f -> f.getEvent() == gameweekNr).collect(Collectors.toList());
	}

	@Override
	public JsonUser getUser(int id)
			  throws XClientException
	{
		checkExceptions();
		return user;
	}

	@Override
	public JsonUserHistory getUserHistory(int id)
			  throws XClientException
	{
		checkExceptions();
		return userHistory;
	}

	@Override
	public JsonEntryGameweek getEntryGameweek(int entity, int event)
			  throws XClientException
	{
		checkExceptions();
		return entryGameweek;
	}

}
