/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
	}
}
