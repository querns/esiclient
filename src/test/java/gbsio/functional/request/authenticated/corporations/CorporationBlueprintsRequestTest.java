package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Blueprint;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationBlueprintsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationBlueprintsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Blueprint>> response = getClient().sendRequest(new CorporationBlueprintsRequest(
            getPropertyAsInt("my_5s_id"),
            getAccessToken("my_5s_token")
        )).join();

        final ImmutableList<Blueprint> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}