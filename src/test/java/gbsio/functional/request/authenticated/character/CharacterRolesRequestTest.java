package gbsio.functional.request.authenticated.character;

import gbsio.esiclient.api.domain.response.character.CharacterRoles;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CharacterRolesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRolesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CharacterRoles> response = getClient().sendRequest(new CharacterRolesRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final CharacterRoles roles = assertResponseExistsAndGet(response);

        assertTrue(roles.getRoles().size() > 0);
    }
}