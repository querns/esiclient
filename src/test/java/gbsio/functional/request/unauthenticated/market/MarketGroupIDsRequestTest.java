package gbsio.functional.request.unauthenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.MarketGroupIDsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MarketGroupIDsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(new MarketGroupIDsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}