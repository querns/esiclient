package gbsio.functional.request.authenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.CorporationOrder;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.CorporationOrderHistoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationOrderHistoryRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CorporationOrder>> response = getClient().sendRequest(new CorporationOrderHistoryRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<CorporationOrder> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}