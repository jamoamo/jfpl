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

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 *
 * @author James Amoore
 */
public class HttpConnectionTest
{
	@Test
	public void testHandleResponseStatus_200()
	{
		HttpConnection client = new HttpConnection();

		CloseableHttpResponse response = Mockito.mock(CloseableHttpResponse.class);
		Mockito.when(response.getCode()).thenReturn(200);
		Assertions.assertDoesNotThrow(() -> client.handleResponseStatus(response));

	}

	@Test
	public void testHandleResponseStatus_401()
	{
		assertThrowsForStatus(401, XNotAuthorised.class);
	}

	@Test
	public void testHandleResponseStatus_403()
	{
		assertThrowsForStatus(403, XNotAllowed.class);
	}

	@Test
	public void testHandleResponseStatus_404()
	{
		assertThrowsForStatus(404, XResourceNotFound.class);
	}

	@Test
	public void testHandleResponseStatus_503()
	{
		assertThrowsForStatus(503, XServiceUnavailable.class);
	}

	@Test
	public void testHandleResponseStatus_unmappedStatus()
	{
		assertThrowsForStatus(500, XAPIException.class);
	}

	private void assertThrowsForStatus(int statusCode, Class<? extends XClientException> expectedException)
	{
		HttpConnection client = new HttpConnection();

		CloseableHttpResponse response = Mockito.mock(CloseableHttpResponse.class);
		Mockito.when(response.getCode()).thenReturn(statusCode);
		Mockito.when(response.getReasonPhrase()).thenReturn("Reason for " + statusCode);

		Assertions.assertThrows(expectedException, () -> client.handleResponseStatus(response));
	}

}
