package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Blueprint;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CharacterBlueprintsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBlueprintsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Blueprint>> response = getClient().sendRequest(new CharacterBlueprintsRequest(
            getPropertyAsInt("researcher_id"),
            getAccessToken("researcher_token")
        )).join();

        final ImmutableList<Blueprint> list = assertResponseExistsAndGet(response);

        assertTrue(list.size() > 0);
    }
}