package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Moon;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoonImplTest {
    @Test
    void parse() throws IOException {
        Moon moon = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/moon.json"),
            new TypeReference<Moon>() { }
        );

        assertEquals(40000042, moon.getID());
        //noinspection SpellCheckingInspection
        assertEquals("Akpivem I - Moon 1", moon.getName());
        assertEquals(58605102008D, moon.getPosition().getX());
        assertEquals(-3066616285D, moon.getPosition().getY());
        assertEquals(-55193617920D, moon.getPosition().getZ());
        assertEquals(30000003, moon.getSolarSystemID());
    }
}