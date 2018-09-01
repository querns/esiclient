package gbsio.esiclient.internal.domain.response.alliance;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.alliance.AllianceInfo;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AllianceInfoParseTest {
    @Test
    void parse() throws IOException {
        AllianceInfo allianceInfo = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/alliance/alliance.json"),
            new TypeReference<AllianceInfo>() { }
        );

        assertEquals(45678, allianceInfo.getCreatorCorporationID());
        assertEquals(12345, allianceInfo.getCreatorCharacterID());
        assertEquals(ZonedDateTime.parse("2016-06-26T21:00:00Z"), allianceInfo.getCreationDate());
        assertEquals("C C P Alliance", allianceInfo.getName());
        assertEquals("<C C P>", allianceInfo.getTicker());
        assertTrue(allianceInfo.getExecutorCorpID().isPresent());
        assertEquals(98356193, (int)allianceInfo.getExecutorCorpID().get());
        assertFalse(allianceInfo.getFactionID().isPresent());
    }
}