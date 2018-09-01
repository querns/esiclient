package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Ancestry;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AncestryImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Ancestry> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/ancestry.json"),
            new TypeReference<ImmutableList<Ancestry>>() { }
        );

        assertEquals(1, list.size());
        Ancestry ancestry = list.get(0);

        assertEquals(1, ancestry.getBloodlineID());
        assertEquals("Acutely aware of the small population...", ancestry.getDescription());
        assertEquals(12, ancestry.getID());
        assertEquals("Tube Child", ancestry.getName());
        assertTrue(ancestry.getShortDescription().isPresent());
        assertEquals("Manufactured citizens of the State.", ancestry.getShortDescription().get());
        assertFalse(ancestry.getIconID().isPresent());
    }
}