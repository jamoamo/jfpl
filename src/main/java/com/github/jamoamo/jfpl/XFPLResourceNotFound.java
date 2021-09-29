/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

/**
 * An error thrown when a resource on the FPL API cannot be found.
 * 
 * @author James Amoore
 */
public class XFPLResourceNotFound extends Exception
{
	XFPLResourceNotFound(String url)
	{
		super("The URL '" + url + "' could not be found.");
	}
}
