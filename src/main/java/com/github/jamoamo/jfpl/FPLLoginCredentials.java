/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
