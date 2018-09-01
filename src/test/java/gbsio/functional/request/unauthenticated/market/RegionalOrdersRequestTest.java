package gbsio.functional.request.unauthenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.RegionalOrder;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.RegionalOrdersRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RegionalOrdersRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<RegionalOrder>> response = getClient().sendRequest(new RegionalOrdersRequest(
            getPropertyAsInt("the_forge_region_id"),
            RegionalOrdersRequest.OrderType.BUY,
            getPropertyAsInt("plex_item_type_id")
        )).join();

        final ImmutableList<RegionalOrder> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}