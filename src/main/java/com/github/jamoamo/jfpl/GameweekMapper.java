/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jamoamo.jfpl;

import com.github.jamoamo.jfpl.model.FPLGameweek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Maps a game-week from the one returned from the FPL JSON API to one exposed by this library.
 *
 * @author James Amoore
 */
class GameweekMapper
{
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

	protected FPLGameweek mapGameweek(JsonGameweek jsonGameweek)
	{
		LocalDateTime ldt = LocalDateTime.parse(jsonGameweek.getDeadlineTime(), FORMATTER);
		FPLGameweek gameweek =
				  new FPLGameweek(
							 jsonGameweek.getId(), 
							 jsonGameweek.getName(), 
							 ldt, 
							 jsonGameweek.isIsCurrent(), 
							 jsonGameweek.isIsNext(), 
							 jsonGameweek.isFinished());
		return gameweek;
	}
}
