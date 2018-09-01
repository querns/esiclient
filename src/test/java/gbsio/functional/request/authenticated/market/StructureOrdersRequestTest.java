package gbsio.functional.request.authenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.Order;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.StructureOrdersRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StructureOrdersRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        //noinspection SpellCheckingInspection
        final Response<ImmutableList<Order>> response = getClient().sendRequest(new StructureOrdersRequest(
            getPropertyAsLong("thetastar_structure_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<Order> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}