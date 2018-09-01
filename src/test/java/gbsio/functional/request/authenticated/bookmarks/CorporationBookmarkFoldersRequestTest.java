package gbsio.functional.request.authenticated.bookmarks;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkFolder;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.bookmarks.CorporationBookmarkFoldersRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationBookmarkFoldersRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<BookmarkFolder>> response = getClient().sendRequest(new CorporationBookmarkFoldersRequest(
            getPropertyAsInt("my_5s_id"),
            getAccessToken("my_5s_token")
        )).join();

        ImmutableList<BookmarkFolder> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}