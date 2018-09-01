package gbsio.functional.request.unauthenticated.character;

import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CharacterInfoRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterInfoRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final int characterID = getPropertyAsInt("querns_id");

        final Response<CharacterInfo> response = getClient().sendRequest(new CharacterInfoRequest(
            characterID
        )).join();

        final CharacterInfo info = assertResponseExistsAndGet(response);
        assertEquals("Querns", info.getName());
    }
}