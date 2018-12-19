package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.PublicStructureIDsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicStructureIDsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Long>> response = getClient().sendRequest(new PublicStructureIDsRequest()).join();
        final ImmutableList<Long> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
        final Response<ImmutableList<Long>> responseMarkets = getClient().sendRequest(new PublicStructureIDsRequest("market")).join();
        final ImmutableList<Long> listMarkets = assertResponseExistsAndGet(responseMarkets);
        assertTrue(listMarkets.size() > 0);

        // the list of structures with market should be smaller than the total list of structures
        assertTrue(listMarkets.size() < list.size());


    }
}