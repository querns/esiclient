package gbsio.esiclient.internal.domain.response.incursions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.incursions.Incursion;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IncursionImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Incursion> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/incursions/incursions.json"),
            new TypeReference<ImmutableList<Incursion>>() { }
        );

        assertEquals(1, list.size());
        Incursion incursion = list.get(0);

        assertEquals(20000607, incursion.getConstellationID());
        assertEquals(500019, incursion.getFactionID());
        assertTrue(incursion.hasBoss());

        assertEquals(7, incursion.getInfestedSolarSystems().size());
        ImmutableList.of(30004148, 30004149, 30004150, 30004151, 30004152, 30004153, 30004154)
            .forEach(solarSystemID -> assertTrue(incursion.getInfestedSolarSystems().contains(solarSystemID)));

        assertEquals(0.9f, incursion.getInfluence());
        assertEquals(30004154, incursion.getStagingSolarSystemID());
        assertEquals(Incursion.State.MOBILIZING, incursion.getState());
        assertEquals("Incursion", incursion.getType());
    }
}