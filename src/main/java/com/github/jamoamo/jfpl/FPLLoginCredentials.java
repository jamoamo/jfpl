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

/**
 * Class that wraps FPL username and password.
 *
 * @author James Amoore
 */
public class FPLLoginCredentials
{
	private final String username;
	private final String password;

	/**
	 * Create a FPLLoginCredentials using the username and password.
	 *
	 * @param username The user's username on FPL
	 * @param password The user's password on FPL
	 */
	public FPLLoginCredentials(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the Username.
	 */
	protected final String getUsername()
	{
		return username;
	}

	/**
	 * @return the password
	 */
	protected final String getPassword()
	{
		return password;
	}
}
