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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
	private static final int LOGIN_PARAM_COUNT = 4;

	private final CookieStore cookieStore;
	private final CloseableHttpClient httpClient;
	
	//TODO this is crude, rather detect login cookie on client
	private boolean loggedIn = false;
	
	FPLClient()
	{
		cookieStore = new BasicCookieStore();
		httpClient = HttpClientBuilder.create()
				  .setDefaultRequestConfig(RequestConfig.custom()
							 .setCookieSpec(CookieSpecs.STANDARD).build())
				  .setDefaultCookieStore(cookieStore)
				  .build();
	}

	@Override
	public boolean login(FPLLoginCredentials credentials)
			  throws IOException
	{
		HttpPost httpPost = new HttpPost(URL_LOGIN);

		try
		{
			List<NameValuePair> params = new ArrayList<>(LOGIN_PARAM_COUNT);
			params.add(new BasicNameValuePair("login", credentials.getUsername()));

			params.add(new BasicNameValuePair("password", credentials.getPassword()));
			params.add(new BasicNameValuePair("app", "plfpl-web"));
			params.add(new BasicNameValuePair("redirect_uri", "https://fantasy.premierleague.com/a/login"));

			httpPost.setEntity(new UrlEncodedFormEntity(params));

			CloseableHttpResponse response = httpClient.execute(httpPost);
			this.loggedIn = loginResponseWasSucess(response);
			return this.loggedIn;
		}
		finally
		{
			httpPost.releaseConnection();
		}
	}
	
	@Override
	public boolean isLoggedIn()
	{
		return this.loggedIn;
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
	public JsonCurrentUser getCurrentUser()
			  throws IOException
	{
		JsonCurrentUser user = getRequest(URL_CURRENT_USER, JsonCurrentUser.class);
		return user;
	}

	@Override
	public JsonCurrentUserTeam getCurrentUserTeam(int id)
			  throws IOException
	{
		JsonCurrentUserTeam team = getRequest(URL_USER_TEAM + id + URL_SEPARATOR, JsonCurrentUserTeam.class);
		return team;
	}

	@Override
	public JsonUser getUser(int userId)
			  throws IOException
	{
		JsonUser user = getRequest(URL_USER + userId + URL_SEPARATOR, JsonUser.class);
		return user;
	}

	@Override
	public JsonStaticData getStaticData()
			  throws IOException
	{
		JsonStaticData data = getRequest(URL_BOOTSTAP_STATIC, JsonStaticData.class);
		return data;
	}

	@Override
	public List<JsonFixture> getFixtures()
			  throws IOException
	{
		JsonFixture[] data = getRequest(URL_FIXTURES, JsonFixture[].class);
		return Arrays.asList(data);
	}

	@Override
	public List<JsonFixture> getFixturesForGameweek(int gameweekNr)
			  throws IOException
	{
		JsonFixture[] data = getRequest(URL_FIXTURES + "?event=" + gameweekNr, JsonFixture[].class);
		return Arrays.asList(data);
	}

	private <T> T getRequest(String url, Class<T> returnObjectClass)
			  throws IOException
	{
		HttpGet httpGet = new HttpGet(url);
		InputStream is = null;
		try
		{
			CloseableHttpResponse response = this.httpClient.execute(httpGet);

			if(response.getStatusLine().getStatusCode() !=
					   HttpStatus.SC_OK)
			{
				throw new RuntimeException("API Exception: " +
						   response.getStatusLine().getStatusCode());
			}
			is = response.getEntity().getContent();
			Gson gson = new GsonBuilder()
					  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					  .create();
			T responseObject = gson.fromJson(
					  new InputStreamReader(is, Charset.forName("utf-8")), returnObjectClass);
			return responseObject;
		}
		finally
		{
			httpGet.releaseConnection();
		}
	}

	@Override
	public JsonUserHistory getUserHistory(int id)
			  throws IOException
	{
		JsonUserHistory history = getRequest(URL_USER + id + URL_HISTORY, JsonUserHistory.class);
		return history;
	}
}
