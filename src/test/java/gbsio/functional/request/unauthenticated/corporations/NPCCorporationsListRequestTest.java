package gbsio.functional.request.unauthenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.NPCCorporationsListRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCCorporationsListRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(new NPCCorporationsListRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);

        assertTrue(list.size() > 0);
    }
}