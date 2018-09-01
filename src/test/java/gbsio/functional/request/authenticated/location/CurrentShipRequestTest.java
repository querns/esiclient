package gbsio.functional.request.authenticated.location;

import gbsio.esiclient.api.domain.response.location.CurrentShip;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.location.CurrentShipRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrentShipRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CurrentShip> response = getClient().sendRequest(new CurrentShipRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final CurrentShip currentShip = assertResponseExistsAndGet(response);
        assertNotNull(currentShip);
    }
}