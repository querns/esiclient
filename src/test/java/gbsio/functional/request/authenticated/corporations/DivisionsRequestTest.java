package gbsio.functional.request.authenticated.corporations;

import gbsio.esiclient.api.domain.response.corporation.Divisions;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.DivisionsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DivisionsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<Divisions> response = getClient().sendRequest(new DivisionsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final Divisions divisions = assertResponseExistsAndGet(response);
        assertTrue(divisions.getHangars().size() > 0);
        assertTrue(divisions.getWallets().size() > 0);
    }
}