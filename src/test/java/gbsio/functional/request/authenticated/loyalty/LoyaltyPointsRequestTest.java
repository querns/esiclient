package gbsio.functional.request.authenticated.loyalty;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyPointRecord;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.loyalty.LoyaltyPointsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyPointsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<LoyaltyPointRecord>> response = getClient().sendRequest(new LoyaltyPointsRequest(
            getPropertyAsInt("researcher_id"),
            getAccessToken("researcher_token")
        )).join();

        final ImmutableList<LoyaltyPointRecord> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}