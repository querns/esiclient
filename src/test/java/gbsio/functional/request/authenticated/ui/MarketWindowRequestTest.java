package gbsio.functional.request.authenticated.ui;

import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.client.request.ui.MarketWindowRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MarketWindowRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final BooleanResponse response = getClient().sendRequest(new MarketWindowRequest(
            getAccessToken("querns_token"),
            getPropertyAsInt("claw_item_type_id")
        )).join();

        assertBooleanResponseCompletedNormally(response);
    }
}