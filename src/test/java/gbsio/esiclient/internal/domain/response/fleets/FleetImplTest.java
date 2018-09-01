package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.fleets.Fleet;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FleetImplTest {
    @Test
    void parse() throws IOException {
        Fleet fleet = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/fleets/fleet.json"),
            new TypeReference<Fleet>() { }
        );

        assertFalse(fleet.isFreeMove());
        assertFalse(fleet.isRegistered());
        assertFalse(fleet.isVoiceEnabled());
        assertEquals("This is an <b>awesome</b> fleet!", fleet.getMOTD());
    }
}