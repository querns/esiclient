package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.OccupiedSolarSystem;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OccupiedSolarSystemImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<OccupiedSolarSystem> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/factionwarfare/occupiedSolarSystem.json"),
            new TypeReference<ImmutableList<OccupiedSolarSystem>>() { }
        );

        assertEquals(1, list.size());
        OccupiedSolarSystem solarSystem = list.get(0);

        assertEquals(OccupiedSolarSystem.OccupationStatus.UNCONTESTED, solarSystem.getStatus());
        assertEquals(500001, solarSystem.getOccupierFactionID());
        assertEquals(500001, solarSystem.getOccupierFactionID());
        assertEquals(30002096, solarSystem.getSolarSystemID());
        assertEquals(60, solarSystem.getVictoryPoints());
        assertEquals(3000, solarSystem.getVictoryPointThreshold());
    }
}