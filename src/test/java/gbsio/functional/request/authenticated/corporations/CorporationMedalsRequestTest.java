package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.corporation.CorporationMedal;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationMedalsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationMedalsRequestTest {
    @Test
    void request() throws IOException {
        Client client = FunctionalTestHarness.getClient();
        String authToken = FunctionalTestHarness.getAccessToken("goonwaffe_token");

        final Response<ImmutableList<CorporationMedal>> medals = client.sendRequest(new CorporationMedalsRequest(
            Integer.valueOf(FunctionalTestHarness.getProperty("goonwaffe_id")),
            authToken
        )).join();

        assertTrue(medals.getResponseObject().isPresent());
        assertTrue(medals.getResponseObject().get().size() > 0);
    }
}