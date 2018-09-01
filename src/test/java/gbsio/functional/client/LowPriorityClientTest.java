package gbsio.functional.client;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.ItemTypeIDsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LowPriorityClientTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Integer>> response = getClient()
            .withLowPriority()
            .sendRequest(new ItemTypeIDsRequest())
            .join()
            ;

        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 1000);
    }
}
