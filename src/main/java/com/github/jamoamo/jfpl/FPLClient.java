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

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class FPLClient implements IFPLClient
{
	private static final Logger LOGGER = LogManager.getLogger(FPLClient.class);

	private static final String URL_FPL_API = "https://fantasy.premierleague.com/api/";
	private static final String URL_BOOTSTAP_STATIC = "%sbootstrap-static/";
	private static final String URL_FIXTURES = "%sfixtures/";
	private static final String URL_USER = "%sentry/";
	private static final String URL_SEPARATOR = "/";
	private static final String URL_HISTORY = "/history/";
	private static final String URL_ENTRY_GAMEWEEK = "%sentry/%d/event/%d/picks/";
	private static final String URL_LIVE_GAMEWEEK = "%sevent/%d/live/";

	private final HttpConnection request;

	private final String apiUrl;

	FPLClient()
	{
		this(URL_FPL_API);
	}

	/**
	 * Test-only constructor allowing the API base URL to be overridden, e.g. to point at a mock server.
	 * Not exposed publicly so that untrusted code cannot redirect API calls at runtime.
	 *
	 * @param apiUrl the base URL to use for API requests
	 */
	FPLClient(String apiUrl)
	{
		request = new HttpConnection();
		this.apiUrl = apiUrl;
	}

	@Override
	public JsonUser getUser(int userId)
			  throws XClientException
	{
		JsonUser user = request.getRequest(String.format(URL_USER + userId + URL_SEPARATOR, apiUrl), JsonUser.class);
		return user;
	}

	@Override
	public JsonStaticData getStaticData()
			  throws XClientException
	{
		JsonStaticData data = request.getRequest(String.format(URL_BOOTSTAP_STATIC, apiUrl), JsonStaticData.class);
		return data;
	}

	@Override
	public List<JsonFixture> getFixtures()
			  throws XClientException
	{
		JsonFixture[] data = request.getRequest(String.format(URL_FIXTURES, apiUrl), JsonFixture[].class);
		return Arrays.asList(data);
	}

	@Override
	public List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws XClientException
	{
		JsonFixture[] data = request.getRequest(String.format(URL_FIXTURES + "?event=" + gameweekNr, apiUrl),
															 JsonFixture[].class);
		return Arrays.asList(data);
	}

	@Override
	public JsonUserHistory getUserHistory(int id)
			  throws XClientException
	{
		JsonUserHistory history = request.getRequest(String.format(URL_USER + id + URL_HISTORY, apiUrl),
																	JsonUserHistory.class);
		return history;
	}

	@Override
	public JsonEntryGameweek getEntryGameweek(int entity, int event)
			  throws XClientException
	{
		JsonEntryGameweek entryGameweek = request.getRequest(String.format(URL_ENTRY_GAMEWEEK, apiUrl, entity, event),
																			  JsonEntryGameweek.class);
		return entryGameweek;
	}

	@Override
	public JsonLiveGameweek getLiveGameweek(int event)
			  throws XClientException
	{
		JsonLiveGameweek liveGameweek = request.getRequest(String.format(URL_LIVE_GAMEWEEK, apiUrl, event),
																		  JsonLiveGameweek.class);
		return liveGameweek;
	}
}
