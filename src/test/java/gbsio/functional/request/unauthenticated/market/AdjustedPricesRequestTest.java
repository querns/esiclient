package gbsio.functional.request.unauthenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.AdjustedPriceData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.AdjustedPricesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AdjustedPricesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<AdjustedPriceData>> response = getClient().sendRequest(new AdjustedPricesRequest()).join();
        final ImmutableList<AdjustedPriceData> list = assertResponseExistsAndGet(response);
        final int clawTypeID = getPropertyAsInt("claw_item_type_id");

        assertTrue(list.size() > 0);
        assertTrue(list.stream()
            .anyMatch(adjustedPriceData -> adjustedPriceData.getItemTypeID() == clawTypeID)
        );
    }
}