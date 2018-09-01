package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CorporationInfoImplTest {
    @Test
    void parse() throws IOException {
        CorporationInfo info = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/corporationInfo.json"),
            new TypeReference<CorporationInfo>() { }
        );

        assertTrue(info.getAllianceID().isPresent());
        assertEquals((Integer)434243723, info.getAllianceID().get());
        assertEquals(180548812, info.getCeoID());
        assertEquals(180548812, info.getCreatorID());
        assertTrue(info.getFoundingDate().isPresent());
        assertEquals(ZonedDateTime.parse("2004-11-28T16:42:51Z"), info.getFoundingDate().get());
        assertTrue(info.getDescription().isPresent());
        assertEquals("This is a corporation description, it's basically just a string", info.getDescription().get());
        assertEquals(656, info.getMemberCount());
        assertEquals("C C P", info.getName());
        assertEquals(0.256f, info.getTaxRate());
        assertEquals("-CCP-", info.getTicker());
        assertTrue(info.getURL().isPresent());
        assertEquals("http://www.eveonline.com", info.getURL().get());

        assertFalse(info.getFactionID().isPresent());
        assertFalse(info.getHomeStationID().isPresent());
        assertFalse(info.getShares().isPresent());
    }
}