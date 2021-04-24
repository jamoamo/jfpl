/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLPlayer;
import java.util.List;

/**
 *
 * @author James Amoore
 */
class FPLDataCache
{
	private JsonStaticData staticData;
	
	JsonStaticData getStaticData()
	{
		return this.staticData;
	}
	
	void storeStaticData(JsonStaticData staticData)
	{
		this.staticData = staticData;
	}
}
