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

import com.github.jamoamo.jfpl.model.FPLFixture;
import com.github.jamoamo.jfpl.model.FPLTeam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Maps a fixture from the one returned from the FPL JSON API to one exposed by this library.
 *
 * @author James Amoore
 */
class FixtureMapper
{
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

	protected FPLFixture mapFixture(final JsonFixture jsonFixture, final Map<Integer, FPLTeam> teamMap)
	{
		FPLTeam homeTeam = teamMap.get(jsonFixture.getTeamH());
		FPLTeam awayTeam = teamMap.get(jsonFixture.getTeamA());
		LocalDateTime kickoff = null;
		if(jsonFixture.getKickoffTime() != null)
		{
			kickoff = LocalDateTime.parse(jsonFixture.getKickoffTime(), FORMATTER);
		}
		return new FPLFixture(jsonFixture.getId(), jsonFixture.getEvent(), kickoff, homeTeam, awayTeam, jsonFixture.
									 getTeamHDifficulty(), jsonFixture.getTeamADifficulty());
	}
}
