package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.SolarSystem;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolarSystemImplTest {
    @Test
    void parse() throws IOException {
        SolarSystem system = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/solarSystem.json"),
            new TypeReference<SolarSystem>() { }
        );

        assertEquals(20000001, system.getConstellationID());
        //noinspection SpellCheckingInspection
        assertEquals("Akpivem", system.getName());
        assertEquals(-91174141133075340D, system.getPosition().getX());
        assertEquals(43938227486247170D, system.getPosition().getY());
        assertEquals(-56482824383339900D, system.getPosition().getZ());
        assertTrue(system.getSecurityClass().isPresent());
        assertEquals("B", system.getSecurityClass().get());
        assertEquals(0.8462923765F, system.getSecurityStatus());
        assertTrue(system.getStarID().isPresent());
        assertEquals((Integer)40000040, system.getStarID().get());
        assertEquals(1, system.getStargateIDs().size());
        assertTrue(system.getStargateIDs().contains(50000342));
        assertEquals(30000003, system.getID());

        assertEquals(2, system.getPlanets().size());
        SolarSystem.PlanetData one = system.getPlanets().get(0);
        SolarSystem.PlanetData two = system.getPlanets().get(1);

        assertEquals(0, one.getAsteroidBeltIDs().size());
        assertEquals(1, one.getMoonIDs().size());
        assertEquals((Integer)40000042, one.getMoonIDs().get(0));
        assertEquals(40000041, one.getPlanetID());

        assertEquals(0, two.getAsteroidBeltIDs().size());
        assertEquals(0, two.getMoonIDs().size());
        assertEquals(40000043, two.getPlanetID());
    }
}