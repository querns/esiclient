package gbsio.functional.request.authenticated.bookmarks;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.Bookmark;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.bookmarks.CharacterBookmarksRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterBookmarksRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Bookmark>> response = getClient().sendRequest(new CharacterBookmarksRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        ImmutableList<Bookmark> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}