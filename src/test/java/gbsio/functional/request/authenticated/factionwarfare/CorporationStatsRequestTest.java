package gbsio.functional.request.authenticated.factionwarfare;

import gbsio.esiclient.api.domain.response.factionwarfare.CorporationStats;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.CorporationStatsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationStatsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CorporationStats> response = getClient().sendRequest(new CorporationStatsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final CorporationStats stats = assertResponseExistsAndGet(response);
        assertNotNull(stats);
    }
}