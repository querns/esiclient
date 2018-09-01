package gbsio.functional.request.authenticated.ui;

import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.client.request.ui.ContractWindowRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContractWindowRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final BooleanResponse response = getClient().sendRequest(new ContractWindowRequest(
            getAccessToken("querns_token"),
            12345
        )).join();

        assertBooleanResponseCompletedNormally(response);
    }
}