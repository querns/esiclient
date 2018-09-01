package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Star;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StarImplTest {
    @Test
    void parse() throws IOException {
        Star star = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/star.json"),
            new TypeReference<Star>() { }
        );

        assertEquals(9398686722L, star.getAge());
        assertEquals(0.0661500022F, star.getLuminosity());
        assertEquals("BKG-Q2 - Star", star.getName());
        assertEquals(346600000, star.getRadius());
        assertEquals(30004333, star.getSolarSystemID());
        assertEquals("K2 V", star.getSpectralClass());
        assertEquals(3953, star.getTemperature());
        assertEquals(45033, star.getItemTypeID());
    }
}