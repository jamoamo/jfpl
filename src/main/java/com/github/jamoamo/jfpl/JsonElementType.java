/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
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

import java.util.List;

/**
 *
 * @author James Amoore
 */
class JsonElementType
{
	private int id;
	private String pluralName;
	private String pluralNameShort;
	private String singularName;
	private String singularNameShort;
	private int squadSelect;
	private int squadMinPlay;
	private int squadMaxPlay;
	private List<Integer> subPositionsLocked;
	private int elementCount;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getPluralName()
	{
		return pluralName;
	}

	public void setPluralName(String pluralName)
	{
		this.pluralName = pluralName;
	}

	public String getPluralNameShort()
	{
		return pluralNameShort;
	}

	public void setPluralNameShort(String pluralNameShort)
	{
		this.pluralNameShort = pluralNameShort;
	}
	
	public String getSingularName()
	{
		return singularName;
	}

	public void setSingularName(String singularName)
	{
		this.singularName = singularName;
	}

	public String getSingularNameShort()
	{
		return singularNameShort;
	}

	public void setSingularNameShort(String singularNameShort)
	{
		this.singularNameShort = singularNameShort;
	}

	public int getSquadSelect()
	{
		return squadSelect;
	}

	public void setSquadSelect(int squadSelect)
	{
		this.squadSelect = squadSelect;
	}

	public int getSquadMinPlay()
	{
		return squadMinPlay;
	}

	public void setSquadMinPlay(int squadMinPlay)
	{
		this.squadMinPlay = squadMinPlay;
	}

	public int getSquadMaxPlay()
	{
		return squadMaxPlay;
	}

	public void setSquadMaxPlay(int squadMaxPlay)
	{
		this.squadMaxPlay = squadMaxPlay;
	}

	public List<Integer> getSubPositionsLocked()
	{
		return subPositionsLocked;
	}

	public void setSubPositionsLocked(List<Integer> subPositionsLocked)
	{
		this.subPositionsLocked = subPositionsLocked;
	}

	public int getElementCount()
	{
		return elementCount;
	}

	public void setElementCount(int elementCount)
	{
		this.elementCount = elementCount;
	}
	
	
}
