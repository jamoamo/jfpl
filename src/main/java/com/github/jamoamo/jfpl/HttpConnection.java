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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author James Amoore
 */
class HttpConnection
{
	private static final Logger LOGGER = LogManager.getLogger(FPLClient.class);
	
	private final CookieStore cookieStore;
	private final CloseableHttpClient httpClient;
	
	private boolean loggedIn;
	
	HttpConnection()
	{
		cookieStore = new BasicCookieStore();
		httpClient = HttpClientBuilder.create()
				  .setDefaultRequestConfig(RequestConfig.custom()
							 .setCookieSpec(CookieSpecs.STANDARD).build())
				  .setDefaultCookieStore(cookieStore)
				  .build();
	}
	
	public boolean execute(String url, List<NameValuePair> params, Function<CloseableHttpResponse, Boolean> validator)
	{
		HttpPost httpPost = new HttpPost(url);

		try
		{
			httpPost.setEntity(new UrlEncodedFormEntity(params));

			CloseableHttpResponse response = httpClient.execute(httpPost);
			return validator.apply(response);
		}
		catch(IOException ex)
		{
			throw new XConnectionException(ex);
		}
		finally
		{
			httpPost.releaseConnection();
		}
	}
	
	public boolean isLoggedIn()
	{
		return this.loggedIn;
	}
	
	public <T> T getRequest(String url, Class<T> returnObjectClass)
			  throws XClientException
	{
		HttpGet httpGet = new HttpGet(url);
		InputStream is = null;
		try
		{
			LOGGER.info(String.format("Request to url [%s]", url));
			CloseableHttpResponse response = this.httpClient.execute(httpGet);
			LOGGER.info(String.format("Response: %s", response.getStatusLine().getStatusCode()));

			handleResponseStatus(response);
			return processResponse(response, returnObjectClass);
		}
		catch(IOException ex)
		{
			LOGGER.error("Request failed", ex);
			throw new XConnectionException(ex);
		}
		finally
		{
			httpGet.releaseConnection();
		}
	}

	protected void handleResponseStatus(CloseableHttpResponse response)
			  throws XClientException
	{
		if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
		{
			return;
		}

		switch(response.getStatusLine().getStatusCode())
		{
			case HttpStatus.SC_SERVICE_UNAVAILABLE:
				throw new XServiceUnavailable(response.getStatusLine().getReasonPhrase());
			case HttpStatus.SC_FORBIDDEN:
				throw new XNotAllowed(response.getStatusLine().getReasonPhrase());
			case HttpStatus.SC_UNAUTHORIZED:
				throw new XNotAuthorised();
			default:
				throw new XAPIException("API Exception. Response Code: " + response.getStatusLine().getStatusCode());
		}
	}

	private <T> T processResponse(CloseableHttpResponse response, Class<T> returnObjectClass)
			  throws JsonIOException, JsonSyntaxException, UnsupportedOperationException, IOException
	{
		try
		{
			InputStream is;
			is = response.getEntity().getContent();
			Gson gson = new GsonBuilder()
					  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					  .create();
			T responseObject = gson.fromJson(
					  new InputStreamReader(is, Charset.forName("utf-8")), returnObjectClass);
			return responseObject;
		}
		catch(JsonParseException ex)
		{
			throw new XResponseMappingException(ex);
		}
	}
}
