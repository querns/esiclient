package gbsio.functional.request.authenticated.fleets;

import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.domain.response.fleets.CurrentFleet;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.fleets.CurrentFleetRequest;
import gbsio.esiclient.client.request.fleets.KickFleetMemberRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KickFleetMemberRequestTest extends FunctionalTestHarness {
    @Test
    void requestKick() throws IOException {
        final Client client = getClient();
        final int characterID = getPropertyAsInt("promfem_id");
        final String accessToken = getAccessToken("my_5s_token");
        final int toKickCharacterID = getPropertyAsInt("tironela_id");

        final Response<CurrentFleet> currentFleetResponse = client.sendRequest(new CurrentFleetRequest(
            characterID, accessToken
        )).join();

        if (currentFleetResponse.getErrorType().isPresent() && ErrorType.NOT_FOUND == currentFleetResponse.getErrorType().get()) {
            log("Unable to continue with kick fleet member test; fleet boss is not in a fleet");
        } else {
            final CurrentFleet currentFleet = assertResponseExistsAndGet(currentFleetResponse);
            final long fleetID = currentFleet.getID();

            assertEquals(Role.FLEET_COMMANDER, currentFleet.getRole(), "Test requires that the requesting character be fleet boss");
            final BooleanResponse kickResponse = client.sendRequest(new KickFleetMemberRequest(
                accessToken, fleetID, toKickCharacterID
            )).join();

            assertBooleanResponseCompletedNormally(kickResponse);
            assertTrue(kickResponse.wasSuccessful());
        }
    }
}