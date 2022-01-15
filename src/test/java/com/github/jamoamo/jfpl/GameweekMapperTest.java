/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
		assertEquals(jsonGameweek.isFinished(), result.isFinished());
	}
	
}
