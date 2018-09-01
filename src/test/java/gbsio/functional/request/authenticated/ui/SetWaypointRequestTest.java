package gbsio.functional.request.authenticated.ui;

import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.client.domain.ui.Waypoint;
import gbsio.esiclient.client.request.ui.SetWaypointRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SetWaypointRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        //noinspection SpellCheckingInspection
        final BooleanResponse response = getClient().sendRequest(new SetWaypointRequest(
            getAccessToken("querns_token"),
            new Waypoint(getPropertyAsInt("jita_solar_system_id"))
        )).join();
        assertBooleanResponseCompletedNormally(response);
    }
}