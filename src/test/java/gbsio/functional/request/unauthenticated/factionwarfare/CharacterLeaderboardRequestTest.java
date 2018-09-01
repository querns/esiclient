package gbsio.functional.request.unauthenticated.factionwarfare;

import gbsio.esiclient.api.domain.response.factionwarfare.CharacterLeaderboard;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.CharacterLeaderboardRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterLeaderboardRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<CharacterLeaderboard> response = getClient().sendRequest(new CharacterLeaderboardRequest()).join();
        final CharacterLeaderboard leaderboard = assertResponseExistsAndGet(response);
        assertNotNull(leaderboard);
    }
}