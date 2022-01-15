/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 * An exception that occurs when parsing the response from the FPL API.
 *
 * @author James Amoore
 */
public class XFPLAPIResponseException extends RuntimeException
{
	private static final String ERROR_MESSAGE = "There was an error interpreting the response from FPL.";

	XFPLAPIResponseException()
	{
		super(ERROR_MESSAGE);
	}

	XFPLAPIResponseException(Exception cause)
	{
		super(ERROR_MESSAGE, cause);
	}
}
