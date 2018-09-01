package gbsio.functional.request.unauthenticated.character;

import gbsio.esiclient.api.domain.response.character.PortraitURLs;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.PortraitsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PortraitsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<PortraitURLs> response = getClient().sendRequest(new PortraitsRequest(
            getPropertyAsInt("querns_id")
        )).join();

        PortraitURLs urls = assertResponseExistsAndGet(response);

        assertTrue(
            urls.get64x64().isPresent()
            || urls.get128x128().isPresent()
            || urls.get256x256().isPresent()
            || urls.get512x512().isPresent()
        );
    }
}