package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Structure;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StructureImplTest {
    @Test
    void parse() throws IOException {
        Structure structure = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/structure.json"),
            new TypeReference<Structure>() { }
        );

        assertEquals("V-3YG7 VI - The Capital", structure.getName());
        assertEquals(109299958, structure.getOwnerCorporationID());
        assertEquals(30000142, structure.getSolarSystemID());

        assertFalse(structure.getPosition().isPresent());
        assertFalse(structure.getItemTypeID().isPresent());
    }
}