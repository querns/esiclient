package gbsio.functional.request.unauthenticated.market;

import gbsio.esiclient.api.domain.response.market.MarketGroup;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.MarketGroupRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketGroupRequestTest extends FunctionalTestHarness {
    private static final int MARKET_GROUP_ID = 10;

    @Test
    void request() {
        final Response<MarketGroup> response = getClient().sendRequest(new MarketGroupRequest(MARKET_GROUP_ID)).join();
        final MarketGroup group = assertResponseExistsAndGet(response);
        assertNotNull(group);
    }
}