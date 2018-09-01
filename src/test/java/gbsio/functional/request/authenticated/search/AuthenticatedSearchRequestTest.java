package gbsio.functional.request.authenticated.search;

import gbsio.esiclient.api.domain.request.search.SearchCategory;
import gbsio.esiclient.api.domain.response.search.SearchResults;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.search.SearchQueryBuilder;
import gbsio.esiclient.client.request.search.AuthenticatedSearchRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatedSearchRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<SearchResults> response = getClient().sendRequest(new AuthenticatedSearchRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token"),
            new SearchQueryBuilder("1DQ1-A", SearchCategory.STRUCTURE)
                .setStrict(false)
                .build()
        )).join();

        final SearchResults results = assertResponseExistsAndGet(response);
        assertNotNull(results);
        assertTrue(results.getStructures().size() > 0);
    }
}