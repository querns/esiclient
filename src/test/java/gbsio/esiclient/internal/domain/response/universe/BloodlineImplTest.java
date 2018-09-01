package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Bloodline;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BloodlineImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Bloodline> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/bloodline.json"),
            new TypeReference<ImmutableList<Bloodline>>() { }

        );

        assertEquals(1, list.size());
        Bloodline bloodline = list.get(0);

        assertEquals(1, bloodline.getID());
        assertEquals(6, bloodline.getCharisma());
        assertEquals(1000006, bloodline.getCorporationID());
        //noinspection SpellCheckingInspection
        assertEquals("The Deteis are regarded as ...", bloodline.getDescription());
        assertEquals(7, bloodline.getIntelligence());
        assertEquals(7, bloodline.getMemory());
        //noinspection SpellCheckingInspection
        assertEquals("Deteis", bloodline.getName());
        assertEquals(5, bloodline.getPerception());
        assertEquals(1, bloodline.getRaceID());
        assertEquals(601, bloodline.getShipItemTypeID());
        assertEquals(5, bloodline.getWillpower());
    }
}