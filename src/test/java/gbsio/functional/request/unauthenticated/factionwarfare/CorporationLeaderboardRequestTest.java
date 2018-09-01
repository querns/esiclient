package gbsio.functional.request.unauthenticated.factionwarfare;

import gbsio.esiclient.api.domain.response.factionwarfare.CorporationLeaderboard;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.CorporationLeaderboardRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorporationLeaderboardRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<CorporationLeaderboard> response = getClient().sendRequest(new CorporationLeaderboardRequest()).join();
        final CorporationLeaderboard leaderboard = assertResponseExistsAndGet(response);
        assertNotNull(leaderboard);
    }
}