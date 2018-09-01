package gbsio.functional.request.authenticated.location;

import gbsio.esiclient.api.domain.response.location.Location;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.location.CurrentLocationRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrentLocationRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<Location> response = getClient().sendRequest(new CurrentLocationRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final Location location = assertResponseExistsAndGet(response);
        assertNotNull(location);
    }
}