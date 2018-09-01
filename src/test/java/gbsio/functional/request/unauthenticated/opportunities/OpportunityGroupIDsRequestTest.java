package gbsio.functional.request.unauthenticated.opportunities;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.opportunities.OpportunityGroupIDsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityGroupIDsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(new OpportunityGroupIDsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}