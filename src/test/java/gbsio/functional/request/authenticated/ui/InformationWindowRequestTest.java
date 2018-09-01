package gbsio.functional.request.authenticated.ui;

import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.client.request.ui.InformationWindowRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InformationWindowRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final BooleanResponse response = getClient().sendRequest(new InformationWindowRequest(
            getAccessToken("querns_token"),
            getPropertyAsInt("querns_id")
        )).join();

        assertBooleanResponseCompletedNormally(response);
    }
}