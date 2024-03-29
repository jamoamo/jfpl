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

import com.github.jamoamo.jfpl.model.FPLRegion;
import com.github.jamoamo.jfpl.model.FPLTeam;
import com.github.jamoamo.jfpl.model.FPLUser;
import java.util.Map;

/**
 *
 * @author James Amoore
 */
class UserMapper
{
	private static final double FACTOR_OF_TEN = 10.0;

	protected FPLUser mapUser(JsonUser user, Map<Integer, FPLTeam> team)
	{
		return new FPLUser(
				  user.getId(),
				  user.getName(),
				  user.getPlayerFirstName(),
				  user.getPlayerLastName(),
				  team.get(user.getFavouriteTeam()),
				  mapRegion(user),
				  user.getLastDeadlineBank() / FACTOR_OF_TEN,
				  user.getSummaryOverallPoints(),
				  user.getSummaryOverallRank(),
				  user.getStartedEvent(),
				  user.getSummaryEventPoints(),
				  user.getLastDeadlineValue() / FACTOR_OF_TEN,
				  user.getCurrentEvent()
		);
	}

	private FPLRegion mapRegion(JsonUser user)
	{
		FPLRegion region = new FPLRegion(user.getPlayerRegionId(),
													user.getPlayerRegionName(),
													user.getPlayerRegionIsoCodeLong(),
													user.getPlayerRegionIsoCodeShort());
		return region;
	}
}
