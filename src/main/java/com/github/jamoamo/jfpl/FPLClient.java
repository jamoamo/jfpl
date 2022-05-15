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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

class FPLClient implements IFPLClient
{
	private static final String URL_FPL_API = "https://fantasy.premierleague.com/api/";
	private static final String URL_BOOTSTAP_STATIC = URL_FPL_API + "bootstrap-static/";
	private static final String URL_FIXTURES = URL_FPL_API + "fixtures/";
	private static final String URL_LOGIN = "https://users.premierleague.com/accounts/login/";
	private static final String URL_CURRENT_USER = URL_FPL_API + "me/";
	private static final String URL_USER_TEAM = URL_FPL_API + "my-team/";
	private static final String URL_USER = URL_FPL_API + "entry/";
	private static final String URL_SEPARATOR = "/";
	private static final String URL_HISTORY = "/history/";
	private static final String URL_ENTRY_GAMEWEEK = URL_FPL_API + "/entry/%d/event/%d/picks/";
	private static final int LOGIN_PARAM_COUNT = 4;

	private final HttpConnection request;

	FPLClient()
	{
		request = new HttpConnection();
	}

	@Override
	public boolean login(FPLLoginCredentials credentials)
			  throws XClientException
	{
		HttpPost httpPost = new HttpPost(URL_LOGIN);

		try
		{
			List<NameValuePair> params = new ArrayList<>(LOGIN_PARAM_COUNT);
			params.add(new BasicNameValuePair("login", credentials.getUsername()));

			params.add(new BasicNameValuePair("password", credentials.getPassword()));
			params.add(new BasicNameValuePair("app", "plfpl-web"));
			params.add(new BasicNameValuePair("redirect_uri", "https://fantasy.premierleague.com/a/login"));

			request.execute(URL_LOGIN, params, response -> loginResponseWasSucess(response));
		}
		finally
		{
			httpPost.releaseConnection();
		}
		return true;
	}
	
	private boolean loginResponseWasSucess(CloseableHttpResponse response)
	{
		Header[] headers = response.getAllHeaders();
		for(Header header : headers)
		{
			if(header.getName().equalsIgnoreCase("location"))
			{
				String locationValue = header.getValue();
				Pattern p = Pattern.compile(
						  "https[:]//fantasy[.]premierleague[.]com/a/login[?]state[=]success[;]?");
				return p.matcher(locationValue).matches();
			}
		}
		return false;
	}

	@Override
	public boolean isLoggedIn()
	{
		return request.isLoggedIn();
	}

	@Override
	public JsonCurrentUser getCurrentUser()
			  throws XClientException
	{
		JsonCurrentUser user = request.getRequest(URL_CURRENT_USER, JsonCurrentUser.class);
		return user;
	}

	@Override
	public JsonCurrentUserTeam getCurrentUserTeam(int id)
			  throws XClientException
	{
		JsonCurrentUserTeam team = request.getRequest(URL_USER_TEAM + id + URL_SEPARATOR, JsonCurrentUserTeam.class);
		return team;
	}

	@Override
	public JsonUser getUser(int userId)
			  throws XClientException
	{
		JsonUser user = request.getRequest(URL_USER + userId + URL_SEPARATOR, JsonUser.class);
		return user;
	}

	@Override
	public JsonStaticData getStaticData()
			  throws XClientException
	{
		JsonStaticData data = request.getRequest(URL_BOOTSTAP_STATIC, JsonStaticData.class);
		return data;
	}

	@Override
	public List<JsonFixture> getFixtures()
			  throws XClientException
	{
		JsonFixture[] data = request.getRequest(URL_FIXTURES, JsonFixture[].class);
		return Arrays.asList(data);
	}

	@Override
	public List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws XClientException
	{
		JsonFixture[] data = request.getRequest(URL_FIXTURES + "?event=" + gameweekNr, JsonFixture[].class);
		return Arrays.asList(data);
	}

	@Override
	public JsonUserHistory getUserHistory(int id)
			  throws XClientException
	{
		JsonUserHistory history = request.getRequest(URL_USER + id + URL_HISTORY, JsonUserHistory.class);
		return history;
	}

	@Override
	public JsonEntryGameweek getEntryGameweek(int entity, int event)
			  throws XClientException
	{
		JsonEntryGameweek entryGameweek = request.getRequest(String.format(URL_ENTRY_GAMEWEEK, entity, event),
																	JsonEntryGameweek.class);
		return entryGameweek;
	}
}
