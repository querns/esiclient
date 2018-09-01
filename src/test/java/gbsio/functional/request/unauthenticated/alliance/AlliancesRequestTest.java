package gbsio.functional.request.unauthenticated.alliance;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.alliance.AlliancesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AlliancesRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(new AlliancesRequest()).join();
        final ImmutableList<Integer> allianceIDs = assertResponseExistsAndGet(response);

        assertTrue(allianceIDs.size() > 0);
    }
}