package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Region;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegionImplTest {
    @Test
    void parse() throws IOException {
        Region region = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/region.json"),
            new TypeReference<Region>() { }
        );

        assertEquals(2, region.getConstellationIDs().size());
        assertTrue(region.getConstellationIDs().containsAll(ImmutableList.of(20000302, 20000303)));
        assertTrue(region.getDescription().isPresent());
        assertEquals("It has long been an established fact of civilization...", region.getDescription().get());
        assertEquals("Metropolis", region.getName());
        assertEquals(10000042, region.getID());
    }
}