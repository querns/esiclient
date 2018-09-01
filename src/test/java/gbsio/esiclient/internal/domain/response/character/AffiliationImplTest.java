package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.Affiliation;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AffiliationImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Affiliation> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/character/affiliation.json"),
            new TypeReference<ImmutableList<Affiliation>>() { }
        );

        assertEquals(1, list.size());
        Affiliation affiliation = list.get(0);

        assertTrue(affiliation.getAllianceID().isPresent());
        assertFalse(affiliation.getFactionID().isPresent());

        assertEquals((Integer)434243723, affiliation.getAllianceID().get());
        assertEquals(95538921, affiliation.getCharacterID());
        assertEquals(109299958, affiliation.getCorporationID());
    }
}