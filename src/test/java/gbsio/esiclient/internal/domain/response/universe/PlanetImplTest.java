package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Planet;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PlanetImplTest {
    @Test
    void parse() throws IOException {
        Planet planet = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/planet.json"),
            new TypeReference<Planet>() { }
        );

        //noinspection SpellCheckingInspection
        assertEquals("Akpivem III", planet.getName());
        assertEquals(40000046, planet.getID());
        assertEquals(-189226344497D, planet.getPosition().getX());
        assertEquals(9901605317D, planet.getPosition().getY());
        assertEquals(-254852632979D, planet.getPosition().getZ());
        assertEquals(30000003, planet.getSolarSystemID());
        assertEquals(13, planet.getItemTypeID());
    }
}