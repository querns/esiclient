package gbsio.functional.request.authenticated.character;

import gbsio.esiclient.api.domain.response.character.FatigueInformation;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.FatigueRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FatigueRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<FatigueInformation> response = getClient().sendRequest(new FatigueRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        FatigueInformation fatigueInformation = assertResponseExistsAndGet(response);
        assertNotNull(fatigueInformation);
    }
}