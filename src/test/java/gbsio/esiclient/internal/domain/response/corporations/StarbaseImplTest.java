package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.Starbase;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StarbaseImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Starbase> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/starbases.json"),
            new TypeReference<ImmutableList<Starbase>>() { }
        );

        assertEquals(1, list.size());
        Starbase starbase = list.get(0);
        assertEquals(12345, starbase.getStarbaseID());
        assertEquals(123456, starbase.getSolarSystemID());
        assertEquals(456, starbase.getItemTypeID());

        assertFalse(starbase.getMoonID().isPresent());
        assertFalse(starbase.getOnlinedSince().isPresent());
        assertFalse(starbase.getReinforcedUntil().isPresent());
        assertFalse(starbase.getState().isPresent());
        assertFalse(starbase.getUnanchorAt().isPresent());
    }
}