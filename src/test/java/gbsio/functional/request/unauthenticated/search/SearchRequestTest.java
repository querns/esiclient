package gbsio.functional.request.unauthenticated.search;

import gbsio.esiclient.api.domain.request.search.SearchCategory;
import gbsio.esiclient.api.domain.response.search.SearchResults;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.search.SearchQueryBuilder;
import gbsio.esiclient.client.request.search.SearchRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<SearchResults> response = getClient().sendRequest(new SearchRequest(
            new SearchQueryBuilder("Delve", true, SearchCategory.REGION, SearchCategory.INVENTORY_TYPE).build()
        )).join();

        final SearchResults results = assertResponseExistsAndGet(response);
        assertNotNull(results);
        assertTrue(results.getRegions().size() > 0);
    }
}