package gbsio.functional.request.authenticated.calendar;

import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.calendar.EventResponseType;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.client.request.calendar.RespondToEventRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RespondToEventRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final int characterID = getPropertyAsInt("promfem_id");
        final String accessToken = getAccessToken("my_5s_token");
        final int eventID = getPropertyAsInt("event_id");

        final BooleanResponse response = client.sendRequest(
            new RespondToEventRequest(characterID, accessToken, eventID, EventResponseType.ACCEPTED)
        ).join();

        assertBooleanResponseCompletedNormally(response);
        assertTrue(response.wasSuccessful());
    }
}