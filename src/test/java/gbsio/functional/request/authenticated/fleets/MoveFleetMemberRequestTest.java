package gbsio.functional.request.authenticated.fleets;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.domain.response.fleets.CurrentFleet;
import gbsio.esiclient.api.domain.response.fleets.FleetMember;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.fleets.HierarchyAssignmentBuilder;
import gbsio.esiclient.client.request.fleets.CurrentFleetRequest;
import gbsio.esiclient.client.request.fleets.FleetMembersRequest;
import gbsio.esiclient.client.request.fleets.MoveFleetMemberRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @TODO("James") Verify squad commander functionality if CCP fixes the bug
 * @link https://github.com/esi/esi-issues/issues/690
 */
class MoveFleetMemberRequestTest extends FunctionalTestHarness {
    @Test
    @Disabled("Assigning a squad member is bugged at the CCP level right now")
    void moveMember() throws IOException {
        Client client = getClient();
        final int characterID = getPropertyAsInt("promfem_id");
        final String accessToken = getAccessToken("my_5s_token");
        final int characterToMove = getPropertyAsInt("tironela_id");

        final Response<CurrentFleet> currentFleetResponse = client.sendRequest(new CurrentFleetRequest(
            characterID, accessToken
        )).join();

        if (currentFleetResponse.getErrorType().isPresent() && ErrorType.NOT_FOUND == currentFleetResponse.getErrorType().get()) {
            log("Unable to continue with fleet invitation test; character is not in a fleet");
        } else {
            final CurrentFleet currentFleet = assertResponseExistsAndGet(currentFleetResponse);
            final long fleetID = currentFleet.getID();

            assertEquals(Role.FLEET_COMMANDER, currentFleet.getRole(), "Test requires that the requesting character be fleet boss");

            final Response<ImmutableList<FleetMember>> fleetMembersResponse = client.sendRequest(new FleetMembersRequest(
                accessToken, fleetID
            )).join();

            final ImmutableList<FleetMember> memberList = assertResponseExistsAndGet(fleetMembersResponse);
            final Optional<FleetMember> member = memberList.stream()
                .filter(fleetMember -> fleetMember.getCharacterID() == characterToMove)
                .findFirst();

            assertTrue(member.isPresent());
            assertTrue(member.get().getSquadID().isPresent());
            assertTrue(member.get().getWingID().isPresent());

            final BooleanResponse promotionRequest = client.sendRequest(new MoveFleetMemberRequest(
                accessToken,
                fleetID,
                characterToMove,
                new HierarchyAssignmentBuilder(Role.SQUAD_MEMBER)
                    .setSquadID(member.get().getSquadID().get())
                    .setWingID(member.get().getWingID().get())
                    .build()
            )).join();

            assertBooleanResponseCompletedNormally(promotionRequest);
            assertTrue(promotionRequest.wasSuccessful());
        }
    }
}