package gbsio.functional.request.authenticated.location;

import gbsio.esiclient.api.domain.response.location.OnlineStatus;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.location.OnlineStatusRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OnlineStatusRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<OnlineStatus> response = getClient().sendRequest(new OnlineStatusRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final OnlineStatus status = assertResponseExistsAndGet(response);
        assertNotNull(status);
    }
}