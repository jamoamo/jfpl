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

import com.github.jamoamo.jfpl.model.FPLTeam;
import com.github.jamoamo.jfpl.model.FPLUser;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author James Amoore
 */
public class UserMapperTest
{
	@Test
	public void testMapUser()
	{
		JsonUser user = new JsonUser();
		user.setId(57912);
		user.setName("User Name");
		user.setLastDeadlineBank(984);
		user.setLastDeadlineTotalTransfers(1);
		user.setLastDeadlineValue(1010);
		user.setPlayerFirstName("User");
		user.setPlayerLastName("Player");
		user.setPlayerRegionIsoCodeShort("US");
		user.setPlayerRegionIsoCodeLong("USA");
		user.setPlayerRegionName("United States");
		user.setPlayerRegionId(23);
		user.setSummaryEventPoints(23);
		user.setSummaryEventRank(134680);
		user.setSummaryOverallPoints(236);
		user.setSummaryOverallRank(247980);
		user.setFavouriteTeam(13);
		
		Map<Integer, FPLTeam> teams = new HashMap<>();
		teams.put(13, new FPLTeam(13, "Man Utd", "MUN"));
		teams.put(12, new FPLTeam(13, "Man City", "MCI"));
		
		UserMapper mapper = new UserMapper();
		FPLUser fplUser = mapper.mapUser(user, teams);
		
		assertEquals(user.getId(), fplUser.getId());
		assertEquals(user.getName(), fplUser.getTeamName());
		assertEquals(user.getPlayerFirstName(), fplUser.getPlayerFirstName());
		assertEquals(user.getPlayerLastName(), fplUser.getPlayerLastName());
		assertEquals("MUN",fplUser.getFavouriteTeam().getShortName());
		assertEquals(user.getPlayerRegionName(), fplUser.getRegion().getRegionName());
		assertEquals(user.getPlayerRegionId(), fplUser.getRegion().getRegionId());
		assertEquals(user.getPlayerRegionIsoCodeLong(), fplUser.getRegion().getIsoCodeLong());
		assertEquals(user.getPlayerRegionIsoCodeShort(), fplUser.getRegion().getIsoCodeShort());
		assertEquals(user.getSummaryOverallPoints(), fplUser.getOverallPoints());
		assertEquals(user.getSummaryOverallRank(), fplUser.getOverallRank());
		assertEquals(user.getStartedEvent(), fplUser.getEventStarted());
		assertEquals(user.getSummaryEventPoints(), fplUser.getGameweekPoints());
		assertEquals(user.getLastDeadlineValue()/10.0, fplUser.getLastDeadlineValue());
		assertEquals(user.getLastDeadlineBank()/10.0, fplUser.getLastDeadlineBank());
		assertEquals(user.getCurrentEvent(), fplUser.getCurrentEvent());
	}
}
