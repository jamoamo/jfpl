/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 * An exception that is thrown when there is a failure connecting to the FPL host.
 * 
 * @author James Amoore
 */
public class XFPLUnavailableException extends RuntimeException
{
	public XFPLUnavailableException()
	{
		super("Unable to connect to FPL.");
	}	
}
