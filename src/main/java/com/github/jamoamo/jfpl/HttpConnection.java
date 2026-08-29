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
import java.util.function.Function;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.cookie.StandardCookieSpec;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author James Amoore
 */
class HttpConnection
{
	private static final Logger LOGGER = LogManager.getLogger(FPLClient.class);
	private static final String MSG_REQUEST_FAILED = "Request failed";
	private static final Gson GSON = new GsonBuilder()
			  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			  .create();

	private final CookieStore cookieStore;
	private final CloseableHttpClient httpClient;

	private boolean loggedIn;

	HttpConnection()
	{
		cookieStore = new BasicCookieStore();
		httpClient = HttpClientBuilder.create()
				  .setDefaultRequestConfig(RequestConfig.custom()
							 .setCookieSpec(StandardCookieSpec.RELAXED).build())
				  .setDefaultCookieStore(cookieStore)
				  .build();
	}

	public boolean execute(String url, List<NameValuePair> params, Function<CloseableHttpResponse, Boolean> validator)
	{
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params));

		try(CloseableHttpResponse response = httpClient.execute(httpPost))
		{
			boolean success = validator.apply(response);
			this.loggedIn = success;
			return success;
		}
		catch(IOException ex)
		{
			LOGGER.error(MSG_REQUEST_FAILED, ex);
			throw new XConnectionException(ex);
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
		try
		{
			LOGGER.info(String.format("Request to url [%s]", url));
			try(CloseableHttpResponse response = this.httpClient.execute(httpGet))
			{
				LOGGER.info(String.format("Response: %s", response.getCode()));

				handleResponseStatus(response);
				return processResponse(response, returnObjectClass);
			}
		}
		catch(IOException ex)
		{
			LOGGER.error(MSG_REQUEST_FAILED, ex);
			throw new XConnectionException(ex);
		}
	}

	protected void handleResponseStatus(CloseableHttpResponse response)
			  throws XClientException
	{
		int statusCode = response.getCode();
		if(statusCode == HttpStatus.SC_OK)
		{
			return;
		}

		LOGGER.warn(String.format("FPL API returned an error status [%d: %s]",
				  statusCode, response.getReasonPhrase()));

		switch(statusCode)
		{
			case HttpStatus.SC_SERVICE_UNAVAILABLE:
				throw new XServiceUnavailable(response.getReasonPhrase());
			case HttpStatus.SC_FORBIDDEN:
				throw new XNotAllowed(response.getReasonPhrase());
			case HttpStatus.SC_UNAUTHORIZED:
				throw new XNotAuthorised();
			case HttpStatus.SC_NOT_FOUND:
				throw new XResourceNotFound();
			default:
				throw new XAPIException("API Exception. Response Code: " + statusCode);
		}
	}

	private <T> T processResponse(CloseableHttpResponse response, Class<T> returnObjectClass)
			  throws JsonIOException, JsonSyntaxException, UnsupportedOperationException, IOException
	{
		try
		{
			InputStream is;
			is = response.getEntity().getContent();
			T responseObject = GSON.fromJson(
					  new InputStreamReader(is, Charset.forName("utf-8")), returnObjectClass);
			return responseObject;
		}
		catch(JsonParseException ex)
		{
			LOGGER.warn("Failed to parse response body", ex);
			throw new XResponseMappingException(ex);
		}
	}
}
