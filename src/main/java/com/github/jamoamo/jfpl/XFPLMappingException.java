/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 * An error that occurs when mapping the FPL API response to the internal models.
 *
 * @author James Amoore
 */
public class XFPLMappingException extends RuntimeException
{
	XFPLMappingException(String message)
	{
		super(message);
	}

	XFPLMappingException(Exception cause)
	{
		super(cause);
	}
}
