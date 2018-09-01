package gbsio.functional.request.authenticated.fleets;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.request.fleets.FleetInvitation;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.domain.response.fleets.CurrentFleet;
import gbsio.esiclient.api.domain.response.fleets.Wing;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.fleets.*;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FleetInvitationTest extends FunctionalTestHarness {
    @Test
    @Disabled
    void invite() throws IOException {
        Client client = getClient();
        final int characterID = getPropertyAsInt("promfem_id");
        final String accessToken = getAccessToken("my_5s_token");
        final int characterToInvite = getPropertyAsInt("tironela_id");

        final Response<CurrentFleet> currentFleetResponse = client.sendRequest(new CurrentFleetRequest(
            characterID, accessToken
        )).join();

        if (currentFleetResponse.getErrorType().isPresent() && ErrorType.NOT_FOUND == currentFleetResponse.getErrorType().get()) {
            log("Unable to continue with fleet invitation test; character is not in a fleet");
        } else {
            final CurrentFleet currentFleet = assertResponseExistsAndGet(currentFleetResponse);
            final long fleetID = currentFleet.getID();

            assertEquals(Role.FLEET_COMMANDER, currentFleet.getRole(), "Test requires that the requesting character be fleet boss");

            final Response<ImmutableList<Wing>> hierarchyResponse = client.sendRequest(new FleetHierarchyRequest(
                accessToken, fleetID
            )).join();

            long wingID;
            boolean createSquad = false;

            final ImmutableList<Wing> wingList = assertResponseExistsAndGet(hierarchyResponse);
            if (wingList.size() > 0) {
                final Wing wing = wingList.get(0);
                wingID = wing.getID();
                if (wing.getSquads().size() == 0) {
                    createSquad = true;
                }
            } else {
                final Response<Long> createWingResponse = client.sendRequest(new CreateWingRequest(
                    accessToken, fleetID
                )).join();
                wingID = assertResponseExistsAndGet(createWingResponse);
                createSquad = true;
            }

            if (createSquad) {
                final Response<Long> createSquadResponse = client.sendRequest(new CreateSquadRequest(
                    accessToken, fleetID, wingID
                )).join();
                assertResponseExistsAndGet(createSquadResponse);
            }

            final BooleanResponse invitationResponse = client.sendRequest(new FleetInvitationRequest(
                accessToken, fleetID, FleetInvitation.squadMember(characterToInvite)
            )).join();
            assertBooleanResponseCompletedNormally(invitationResponse);
            assertTrue(invitationResponse.wasSuccessful());
        }
    }
}