package gbsio.functional.request.unauthenticated.status;

import gbsio.esiclient.api.domain.response.status.ServerStatus;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.status.ServerStatusRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerStatusRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ServerStatus> response = getClient().sendRequest(new ServerStatusRequest()).join();
        final ServerStatus status = assertResponseExistsAndGet(response);
        assertNotNull(status);
    }
}