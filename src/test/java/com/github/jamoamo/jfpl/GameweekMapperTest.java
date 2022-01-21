/*
 * The MIT License
 *
 * Copyright 2022 James Amoore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the So Аftware without restriction, including without limitation the rights
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

import com.github.jamoamo.jfpl.model.FPLGameweek;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James Amoore
 */
public class GameweekMapperTest
{
	
	public GameweekMapperTest()
	{
	}

	/**
	 * Test of mapGameweek method, of class GameweekMapper.
	 */
	@Test
	public void testMapGameweek()
	{
		JsonGameweek jsonGameweek = new JsonGameweek();
		jsonGameweek.setId(4);
		jsonGameweek.setIsCurrent(false);
		jsonGameweek.setFinished(true);
		jsonGameweek.setIsNext(false);
		jsonGameweek.setIsPrevious(true);
		jsonGameweek.setName("Gameweek 4");
		jsonGameweek.setDeadlineTime("2020-09-03T11:30:05Z");
		GameweekMapper instance = new GameweekMapper();
		FPLGameweek result = instance.mapGameweek(jsonGameweek);
		assertEquals(jsonGameweek.getId(), result.getId());
		assertEquals(jsonGameweek.getName(), result.getName());
		assertEquals(2020, result.getDeadlineTime().getYear());
		assertEquals(Month.SEPTEMBER, result.getDeadlineTime().getMonth());
		assertEquals(3, result.getDeadlineTime().getDayOfMonth());
		assertEquals(11, result.getDeadlineTime().getHour());
		assertEquals(30, result.getDeadlineTime().getMinute());
		assertEquals(5, result.getDeadlineTime().getSecond());
		assertEquals(jsonGameweek.isIsCurrent(), result.isCurrent());
		assertEquals(jsonGameweek.isIsNext(), result.isNext());
		assertEquals(jsonGameweek.isIsPrevious(), result.isPrevious());
		assertEquals(jsonGameweek.isFinished(), result.isFinished());
	}
}
