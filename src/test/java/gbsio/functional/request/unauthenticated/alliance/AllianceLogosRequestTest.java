package gbsio.functional.request.unauthenticated.alliance;

import gbsio.esiclient.api.domain.response.alliance.AllianceLogoURLs;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.alliance.AllianceLogosRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AllianceLogosRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<AllianceLogoURLs> response = getClient().sendRequest(new AllianceLogosRequest(getPropertyAsInt("goonswarm_federation_id"))).join();
        AllianceLogoURLs logos = assertResponseExistsAndGet(response);

        assertTrue(logos.getLogo64().isPresent() || logos.getLogo128().isPresent());
    }
}