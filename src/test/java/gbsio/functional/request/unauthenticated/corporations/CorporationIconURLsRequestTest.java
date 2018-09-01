package gbsio.functional.request.unauthenticated.corporations;

import gbsio.esiclient.api.domain.response.corporation.CorporationIconURLs;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationIconURLsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationIconURLsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CorporationIconURLs> response = getClient().sendRequest(new CorporationIconURLsRequest(
            getPropertyAsInt("goonwaffe_id")
        )).join();

        final CorporationIconURLs urls = assertResponseExistsAndGet(response);

        assertTrue(
            urls.getIcon64().isPresent()
            || urls.getIcon128().isPresent()
            || urls.getIcon256().isPresent()
        );
    }
}