package gbsio.functional.request.unauthenticated.alliance;

import gbsio.esiclient.api.domain.response.alliance.AllianceInfo;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.alliance.AllianceInfoRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AllianceInfoRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final int allianceID = Integer.valueOf(getProperty("goonswarm_federation_id"));
        final Response<AllianceInfo> response = getClient().sendRequest(new AllianceInfoRequest(allianceID)).join();

        final AllianceInfo info = assertResponseExistsAndGet(response);
        assertEquals("Goonswarm Federation", info.getName());

    }
}