/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

class FPLDataCache
{
	private JsonStaticData staticData;
	private JsonCurrentUser currentUser;

	JsonStaticData getStaticData()
	{
		return this.staticData;
	}

	JsonCurrentUser getCurrentUser()
	{
		return this.currentUser;
	}

	void storeStaticData(JsonStaticData staticData)
	{
		this.staticData = staticData;
	}

	void storeCurrentUser(JsonCurrentUser user)
	{
		this.currentUser = user;
	}
}
