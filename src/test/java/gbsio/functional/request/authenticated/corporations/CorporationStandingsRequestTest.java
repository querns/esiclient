package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.NPCStandings;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationStandingsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationStandingsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<NPCStandings>> response = getClient().sendRequest(new CorporationStandingsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<NPCStandings> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}