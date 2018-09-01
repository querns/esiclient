package gbsio.functional.request.authenticated.skills;

import gbsio.esiclient.api.domain.response.skills.CharacterAttributes;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.skills.CharacterAttributesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterAttributesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CharacterAttributes> response = getClient().sendRequest(new CharacterAttributesRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final CharacterAttributes attributes = assertResponseExistsAndGet(response);
        assertNotNull(attributes);
    }
}