package gbsio.functional.request.authenticated.bookmarks;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.Bookmark;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.bookmarks.CorporationBookmarksRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationBookmarksRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Bookmark>> response = getClient().sendRequest(new CorporationBookmarksRequest(
            getPropertyAsInt("my_5s_id"),
            getAccessToken("my_5s_token")
        )).join();

        ImmutableList<Bookmark> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}