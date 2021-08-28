/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 *
 * @author James Amoore
 */
public class FPLLoginException extends Exception
{
	public FPLLoginException()
	{
		super("Login failed!");
	}
	
	public FPLLoginException(Exception ex)
	{
		super(ex);
	}
	
}
