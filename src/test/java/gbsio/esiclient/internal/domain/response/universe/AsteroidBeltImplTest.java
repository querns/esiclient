package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.AsteroidBelt;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsteroidBeltImplTest {
    @Test
    void parse() throws IOException {
        AsteroidBelt belt = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/asteroidBelt.json"),
            new TypeReference<AsteroidBelt>() { }
        );

        //noinspection SpellCheckingInspection
        assertEquals("Tanoo I - Asteroid Belt 1", belt.getName());
        Coordinates position = belt.getPosition();

        assertEquals(161967513600D, position.getX());
        assertEquals(21288837120D, position.getY());
        assertEquals(-73505464320D, position.getZ());

        assertEquals(30000001, belt.getSolarSystemID());
    }
}