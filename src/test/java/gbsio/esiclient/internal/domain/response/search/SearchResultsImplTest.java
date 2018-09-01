package gbsio.esiclient.internal.domain.response.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.search.SearchResults;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchResultsImplTest {
    @Test
    void parse() throws IOException {
        SearchResults results = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/search/searchResults.json"),
            new TypeReference<SearchResults>() { }
        );

        assertEquals(1, results.getSolarSystems().size());
        assertEquals(7, results.getStations().size());

        assertEquals(0, results.getAgents().size());
        assertEquals(0, results.getAlliances().size());
        assertEquals(0, results.getCharacters().size());
        assertEquals(0, results.getConstellations().size());
        assertEquals(0, results.getCorporations().size());
        assertEquals(0, results.getFactions().size());
        assertEquals(0, results.getItemTypes().size());
        assertEquals(0, results.getRegions().size());
        assertEquals(0, results.getStructures().size());

        assertTrue(results.getSolarSystems().contains(30002510));
        assertTrue(results.getStations().containsAll(ImmutableList.of(60004588, 60004594, 60005725, 60009106, 60012721, 60012724, 60012727)));
    }
}