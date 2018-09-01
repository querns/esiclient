package gbsio.functional.request.unauthenticated.loyalty;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyStoreOffer;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.loyalty.LoyaltyStoreOffersRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyStoreOffersRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<LoyaltyStoreOffer>> response = getClient().sendRequest(new LoyaltyStoreOffersRequest(
            getPropertyAsInt("caldari_navy_id")
        )).join();

        final ImmutableList<LoyaltyStoreOffer> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}