package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Campaign;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CampaignImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Campaign> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/sovereignty/campaign.json"),
            new TypeReference<ImmutableList<Campaign>>() { }
        );

        assertEquals(1, list.size());
        Campaign campaign = list.get(0);
        assertTrue(campaign.getAttackerScore().isPresent());
        assertEquals((Float)0.4F, campaign.getAttackerScore().get());
        assertEquals(32833, campaign.getID());
        assertEquals(20000125, campaign.getConstellationID());
        assertTrue(campaign.getDefenderID().isPresent());
        assertEquals((Integer)1695357456, campaign.getDefenderID().get());
        assertTrue(campaign.getDefenderScore().isPresent());
        assertEquals((Float)0.6F, campaign.getDefenderScore().get());
        assertEquals(Campaign.CampaignType.STATION_DEFENSE, campaign.getType());
        assertEquals(30000856, campaign.getSolarSystemID());
        assertEquals(ZonedDateTime.parse("2016-10-29T14:34:40Z"), campaign.getStartDate());
        assertEquals(61001096L, campaign.getStructureID());
    }
}