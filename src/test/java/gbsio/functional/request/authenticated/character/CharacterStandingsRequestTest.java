package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.NPCStandings;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CharacterStandingsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStandingsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<NPCStandings>> response = getClient().sendRequest(new CharacterStandingsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<NPCStandings> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}