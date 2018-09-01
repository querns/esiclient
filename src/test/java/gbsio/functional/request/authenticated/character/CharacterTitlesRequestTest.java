package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Title;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CharacterTitlesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTitlesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Title>> response = getClient().sendRequest(new CharacterTitlesRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<Title> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}