package gbsio.esiclient.internal.domain.response.location;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.location.CurrentShip;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrentShipImplTest {
    @Test
    void parse() throws IOException {
        CurrentShip ship = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/location/currentShip.json"),
            new TypeReference<CurrentShip>() { }
        );

        assertEquals(1000000016991L, ship.getItemID());
        assertEquals("SPACESHIPS!!!", ship.getName());
        assertEquals(1233, ship.getItemTypeID());
    }
}