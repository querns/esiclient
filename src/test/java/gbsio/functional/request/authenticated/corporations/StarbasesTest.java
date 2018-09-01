package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.corporation.Starbase;
import gbsio.esiclient.api.domain.response.corporation.StarbaseDetail;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.StarbaseDetailRequest;
import gbsio.esiclient.client.request.corporations.StarbasesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StarbasesTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final int corporationID = getPropertyAsInt("goonwaffe_id");
        final String accessToken = getAccessToken("goonwaffe_token");

        final Response<ImmutableList<Starbase>> starbasesResponse = client.sendRequest(
            new StarbasesRequest(corporationID, accessToken)
        ).join();

        final ImmutableList<Starbase> starbases = assertResponseExistsAndGet(starbasesResponse);

        assertTrue(starbases.size() > 0);
        Starbase starbase = starbases.get(0);

        final Response<StarbaseDetail> detailResponse = client.sendRequest(new StarbaseDetailRequest(
            corporationID, accessToken, starbase.getItemTypeID(), starbase.getSolarSystemID()
        )).join();

        final StarbaseDetail detail = assertResponseExistsAndGet(detailResponse);
        assertNotNull(detail);
    }
}