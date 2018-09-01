package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Schematic;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SchematicImplTest {
    @Test
    void parse() throws IOException {
        Schematic schematic = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/planetaryinteraction/schematic.json"),
            new TypeReference<Schematic>() { }
        );

        assertEquals(1800, schematic.getCycleTime());
        assertEquals("Bacteria", schematic.getName());
    }
}