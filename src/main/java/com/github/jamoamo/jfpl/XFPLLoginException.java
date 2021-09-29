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
public class XFPLLoginException extends Exception
{
	XFPLLoginException()
	{
		super("Login failed!");
	}
	
	XFPLLoginException(Exception ex)
	{
		super(ex);
	}
	
}
