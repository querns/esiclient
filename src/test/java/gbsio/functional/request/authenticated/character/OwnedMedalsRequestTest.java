package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.character.CharacterMedal;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.OwnedMedalsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OwnedMedalsRequestTest {
    @Test
    void request() throws IOException {
        Client client = FunctionalTestHarness.getClient();
        String accessToken = FunctionalTestHarness.getAccessToken("querns_token");
        String characterID = FunctionalTestHarness.getProperty("querns_id");

        final Response<ImmutableList<CharacterMedal>> response = client.sendRequest(
            new OwnedMedalsRequest(Integer.valueOf(characterID), accessToken)
        ).join();

        assertTrue(response.getResponseObject().isPresent());
        assertFalse(response.getError().isPresent());

        ImmutableList<CharacterMedal> medals = response.getResponseObject().get();
        assertTrue(medals.size() > 0);
    }
}