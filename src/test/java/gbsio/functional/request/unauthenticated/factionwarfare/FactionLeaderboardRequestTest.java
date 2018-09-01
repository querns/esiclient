package gbsio.functional.request.unauthenticated.factionwarfare;

import gbsio.esiclient.api.domain.response.factionwarfare.FactionLeaderboard;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.FactionLeaderboardRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactionLeaderboardRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<FactionLeaderboard> response = getClient().sendRequest(new FactionLeaderboardRequest()).join();
        final FactionLeaderboard leaderboard = assertResponseExistsAndGet(response);
        assertNotNull(leaderboard);
    }
}