package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.fleets.CurrentFleet;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrentFleetImplTest {
    @Test
    void parse() throws IOException {
        CurrentFleet fleet = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/fleets/currentFleet.json"),
            new TypeReference<CurrentFleet>() { }
        );

        assertEquals(1234567890L, fleet.getID());
        assertEquals(Role.FLEET_COMMANDER, fleet.getRole());
        assertFalse(fleet.getSquadID().isPresent());
        assertFalse(fleet.getWingID().isPresent());
    }
}