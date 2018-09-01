package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Faction;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FactionImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Faction> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/faction.json"),
            new TypeReference<ImmutableList<Faction>>() { }
        );
        assertTrue(list.size() > 0);
        final Faction faction = list.get(0);

        assertTrue(faction.getCorporationID().isPresent());
        assertEquals(456, faction.getCorporationID().get().intValue());
        assertEquals("blah blah", faction.getDescription());
        assertEquals(1, faction.getID());
        assertTrue(faction.isUnique());
        assertEquals("Faction", faction.getName());
        assertEquals(1F, faction.getSizeFactor());
        assertTrue(faction.getSolarSystemID().isPresent());
        assertEquals(123, faction.getSolarSystemID().get().intValue());
        assertEquals(1000, faction.getStationCount());
        assertEquals(100, faction.getStationSystemCount());
    }
}