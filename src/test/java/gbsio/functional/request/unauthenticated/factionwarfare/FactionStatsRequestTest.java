package gbsio.functional.request.unauthenticated.factionwarfare;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionStats;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.FactionStatsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactionStatsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<FactionStats>> response = getClient().sendRequest(new FactionStatsRequest()).join();
        final ImmutableList<FactionStats> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}