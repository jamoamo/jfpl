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
import java.util.Arrays;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 *
 * @author James Amoore
 */
class FPLClient implements IFPLClient
{
	private static final String URL_FPL_API =  "https://fantasy.premierleague.com/api/";
	private static final String URL_BOOTSTAP_STATIC = URL_FPL_API + "bootstrap-static/";
	private static final String URL_FIXTURES = URL_FPL_API + "fixtures/";
	HttpClient client = new HttpClient();
	
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
		GetMethod getMethod = new GetMethod(url);
		this.client.executeMethod(getMethod);
		if(getMethod.getStatusCode() != 200)
		{
			throw new RuntimeException("API Exception: " + getMethod.getStatusCode());
		}
		InputStream is = getMethod.getResponseBodyAsStream();
		Gson gson = new GsonBuilder()
				  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				  .create();
		T responseObject = gson.fromJson(new InputStreamReader(is, Charset.forName("utf-8")), returnObjectClass);
		return responseObject;
	}
}
