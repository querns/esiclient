package gbsio.functional.request.authenticated.factionwarfare;

import gbsio.esiclient.api.domain.response.factionwarfare.CharacterStats;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.CharacterStatsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStatsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CharacterStats> response = getClient().sendRequest(new CharacterStatsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final CharacterStats stats = assertResponseExistsAndGet(response);
        assertNotNull(stats);
    }
}