package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.IDtoNameResults;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IDtoNameResultsImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<IDtoNameResults> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/universe/bulkNameLookup.json"),
            new TypeReference<ImmutableList<IDtoNameResults>>() { }
        );

        assertEquals(2, list.size());
        IDtoNameResults one = list.get(0);
        IDtoNameResults two = list.get(1);

        assertEquals(IDtoNameResults.Category.CHARACTER, one.getCategory());
        assertEquals(95465499, one.getID());
        assertEquals("CCP Bartender", one.getName());

        assertEquals(IDtoNameResults.Category.SOLAR_SYSTEM, two.getCategory());
        assertEquals(30000142, two.getID());
        //noinspection SpellCheckingInspection
        assertEquals("Jita", two.getName());
    }
}