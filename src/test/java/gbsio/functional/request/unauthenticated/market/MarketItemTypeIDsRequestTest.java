package gbsio.functional.request.unauthenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.MarketItemTypeIDsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MarketItemTypeIDsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final int plexItemTypeID = getPropertyAsInt("plex_item_type_id");
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(new MarketItemTypeIDsRequest(
            getPropertyAsInt("the_forge_region_id")
        )).join();

        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
        assertTrue(list.stream().anyMatch(integer -> integer == plexItemTypeID));
    }
}