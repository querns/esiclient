package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.Constellation;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstellationImplTest {
    @Test
    void parse() throws IOException {
        Constellation constellation = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/constellation.json"),
            new TypeReference<Constellation>() { }
        );

        assertEquals(20000009, constellation.getID());
        //noinspection SpellCheckingInspection
        assertEquals("Mekashtad", constellation.getName());
        assertEquals(10000001, constellation.getRegionID());

        Coordinates position = constellation.getPosition();
        assertEquals(67796138757472320D, position.getX());
        assertEquals(-70591121348560960D, position.getY());
        assertEquals(-59587016159270070D, position.getZ());

        assertEquals(2, constellation.getSolarSystemIDs().size());
        assertTrue(constellation.getSolarSystemIDs().containsAll(ImmutableList.of(20000302, 20000303)));
    }
}