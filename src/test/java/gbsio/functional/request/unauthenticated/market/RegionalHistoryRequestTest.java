package gbsio.functional.request.unauthenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.RegionalHistoricalSummary;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.RegionalHistoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RegionalHistoryRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<RegionalHistoricalSummary>> response = getClient().sendRequest(new RegionalHistoryRequest(
            getPropertyAsInt("the_forge_region_id"),
            getPropertyAsInt("plex_item_type_id")
        )).join();

        final ImmutableList<RegionalHistoricalSummary> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}