package gbsio.functional.request.authenticated.ui;

import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.client.domain.ui.PrefilledMailBuilder;
import gbsio.esiclient.client.request.ui.MailWindowRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MailWindowRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final BooleanResponse response = getClient().sendRequest(new MailWindowRequest(
            getAccessToken("querns_token"),
            new PrefilledMailBuilder("Mail body", "Mail Subject", getPropertyAsInt("querns_id")).build()
        )).join();

        assertBooleanResponseCompletedNormally(response);
    }
}