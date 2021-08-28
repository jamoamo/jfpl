/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author James Amoore
 */
class FPLClient implements IFPLClient
{
	private static final String URL_FPL_API =  "https://fantasy.premierleague.com/api/";
	private static final String URL_BOOTSTAP_STATIC = URL_FPL_API + "bootstrap-static/";
	private static final String URL_FIXTURES = URL_FPL_API + "fixtures/";
	private static final String URL_LOGIN = "https://users.premierleague.com/accounts/login/";
	private static final String URL_CURRENT_USER = URL_FPL_API + "me/";
	private static final String URL_USER = URL_FPL_API + "entry/";
	
	private final CookieStore cookieStore;
	private final CloseableHttpClient httpClient;
	
	public FPLClient()
	{
		cookieStore = new BasicCookieStore();
		httpClient = HttpClientBuilder.create()
								.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
								.setDefaultCookieStore(cookieStore)
								.build();
	}
	
	@Override
	public void login(FPLLoginCredentials credentials)
			  throws Exception
	{
		HttpPost httpPost = new HttpPost(URL_LOGIN);
	
		try
		{
			List<NameValuePair> params = new ArrayList<>(4);
			params.add(new BasicNameValuePair("login",credentials.getUsername()));

			params.add(new BasicNameValuePair("password", credentials.getPassword()));
			params.add(new BasicNameValuePair("app", "plfpl-web"));
			params.add(new BasicNameValuePair("redirect_uri","https://fantasy.premierleague.com/a/login"));

			httpPost.setEntity(new UrlEncodedFormEntity(params));
			
			CloseableHttpResponse response = httpClient.execute(httpPost);
			System.out.println(response.getStatusLine().getReasonPhrase());
			
			List<Cookie> cookies = cookieStore.getCookies();
			for(Cookie cookie : cookies)
			{
				System.out.println(cookie.toString());
			}
		}
		finally
		{
			httpPost.releaseConnection();
		}
	}
	
	@Override
	public JsonCurrentUser getCurrentUser()
			  throws IOException
	{
		JsonCurrentUser user = getRequest(URL_CURRENT_USER, JsonCurrentUser.class);
		return user;
	}
	
	@Override
	public JsonUser getUser(int event_id)
			  throws IOException
	{
		JsonUser user = getRequest(URL_USER + event_id + "/", JsonUser.class);
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
		JsonFixture[] data = getRequest(URL_FIXTURES+ "?event=" + gameweekNr, JsonFixture[].class);
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
						
			if(response.getStatusLine().getStatusCode() != 200)
			{
				throw new RuntimeException("API Exception: " + response.getStatusLine().getStatusCode());
			}
			is = response.getEntity().getContent();
			Gson gson = new GsonBuilder()
					  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					  .create();
			T responseObject = gson.fromJson(new InputStreamReader(is, Charset.forName("utf-8")), returnObjectClass);
			return responseObject;
		}
		finally
		{
			httpGet.releaseConnection();
		}
	}
}
