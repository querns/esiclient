package gbsio.esiclient.internal.domain.response.location;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.location.Location;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LocationImplTest {
    @Test
    void parse() throws IOException {
        Location location = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/location/location.json"),
            new TypeReference<Location>() { }
        );

        assertEquals(30002505, location.getSolarSystemID());
        assertTrue(location.getStructureID().isPresent());
        assertFalse(location.getStationID().isPresent());
        assertEquals((Long)1000000016989L, location.getStructureID().get());
    }
}