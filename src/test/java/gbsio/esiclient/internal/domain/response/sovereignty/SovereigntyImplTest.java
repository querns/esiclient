package gbsio.esiclient.internal.domain.response.sovereignty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Sovereignty;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SovereigntyImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Sovereignty> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/sovereignty/sovereignty.json"),
            new TypeReference<ImmutableList<Sovereignty>>() { }
        );

        assertEquals(1, list.size());
        Sovereignty sovereignty = list.get(0);

        assertFalse(sovereignty.getAllianceID().isPresent());
        assertFalse(sovereignty.getCorporationID().isPresent());
        assertTrue(sovereignty.getFactionID().isPresent());

        assertEquals((Integer)500001, sovereignty.getFactionID().get());
        assertEquals(30045334, sovereignty.getSolarSystemID());
    }
}