package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.IDNamePair;
import gbsio.esiclient.api.domain.response.universe.NameToIDResults;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NameToIDResultsImplTest {
    @Test
    void parse() throws IOException {
        NameToIDResults results = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/bulkIDLookup.json"),
            new TypeReference<NameToIDResults>() { }
        );

        assertEquals(2, results.getCharacters().size());
        assertEquals(1, results.getSolarSystems().size());
        assertEquals(0, results.getAgents().size());
        assertEquals(0, results.getAlliances().size());
        assertEquals(0, results.getConstellations().size());
        assertEquals(0, results.getCorporations().size());
        assertEquals(0, results.getFactions().size());
        assertEquals(0, results.getItemTypes().size());
        assertEquals(0, results.getRegions().size());
        assertEquals(0, results.getStations().size());

        IDNamePair one = results.getCharacters().get(0);
        IDNamePair two = results.getCharacters().get(1);
        IDNamePair three = results.getSolarSystems().get(0);

        assertEquals(95465499, one.getID());
        assertEquals("CCP Bartender", one.getName());
        assertEquals(2112625428, two.getID());
        //noinspection SpellCheckingInspection
        assertEquals("CCP Zoetrope", two.getName());
        assertEquals(30000142, three.getID());
        //noinspection SpellCheckingInspection
        assertEquals("Jita", three.getName());
    }
}