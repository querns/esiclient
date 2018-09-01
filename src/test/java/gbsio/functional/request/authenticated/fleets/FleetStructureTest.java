package gbsio.functional.request.authenticated.fleets;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.domain.response.fleets.*;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.domain.fleets.FleetUpdateBuilder;
import gbsio.esiclient.client.request.fleets.*;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FleetStructureTest extends FunctionalTestHarness {
    private static final String WING_NAME = "Linux";
    private static final String SQUAD_NAME = "LinuxSquad";
    private Client client;
    private int characterID;
    private String accessToken;

    @BeforeEach
    void setUp() throws IOException {
        client = getClient();
        characterID = getPropertyAsInt("promfem_id");
        accessToken = getAccessToken("my_5s_token");
    }

    @Test
    @Disabled
    void createFleet() throws InterruptedException {
        final Response<CurrentFleet> currentFleetResponse = client.sendRequest(new CurrentFleetRequest(
            characterID, accessToken
        )).join();

        if (currentFleetResponse.getErrorType().isPresent() && ErrorType.NOT_FOUND == currentFleetResponse.getErrorType().get()) {
            log("Unable to continue with fleet structure test; character is not in a fleet");
        } else {
            final CurrentFleet currentFleet = assertResponseExistsAndGet(currentFleetResponse);
            final long fleetID = currentFleet.getID();

            assertEquals(Role.FLEET_COMMANDER, currentFleet.getRole(), "Test requires that the requesting character be fleet boss");
            testFleetLevelEndpoints(fleetID);

            // Create Wing
            final Response<Long> createWingResponse = client.sendRequest(new CreateWingRequest(accessToken, fleetID)).join();
            final Long wingID = assertResponseExistsAndGet(createWingResponse);

            // Rename Wing
            final BooleanResponse renameWingResponse = client.sendRequest(new RenameWingRequest(
                accessToken, fleetID, wingID, WING_NAME
            )).join();
            assertBooleanResponseCompletedNormally(renameWingResponse);
            assertTrue(renameWingResponse.wasSuccessful());

            // Create Squad
            final Response<Long> createSquadResponse = client.sendRequest(new CreateSquadRequest(
                accessToken, fleetID, wingID
            )).join();
            final Long squadID = assertResponseExistsAndGet(createSquadResponse);

            // Rename Squad
            final BooleanResponse renameSquadResponse = client.sendRequest(new RenameSquadRequest(
                accessToken, fleetID, squadID, SQUAD_NAME
            )).join();
            assertBooleanResponseCompletedNormally(renameSquadResponse);
            assertTrue(renameSquadResponse.wasSuccessful());

            // Retrieve fleet hierarchy
            final Response<ImmutableList<Wing>> hierarchyResponse = client.sendRequest(new FleetHierarchyRequest(
                accessToken, fleetID
            )).join();
            final ImmutableList<Wing> wings = assertResponseExistsAndGet(hierarchyResponse);

            final Optional<Wing> testWing = wings.stream()
                .filter(wing -> wing.getName().equals(WING_NAME))
                .findFirst();
            assertTrue(testWing.isPresent());

            final Optional<Squad> testSquad = testWing.get().getSquads().stream()
                .filter(squad -> squad.getName().equals(SQUAD_NAME))
                .findFirst();
            assertTrue(testSquad.isPresent());

            Thread.sleep(5_000);

            // Delete Squad
            final BooleanResponse deleteSquadResponse = client.sendRequest(new DeleteSquadRequest(
                accessToken, fleetID, squadID
            )).join();
            assertBooleanResponseCompletedNormally(deleteSquadResponse);
            assertTrue(deleteSquadResponse.wasSuccessful());

            // Delete wing
            final BooleanResponse deleteWingResponse = client.sendRequest(new DeleteWingRequest(
                accessToken, fleetID, wingID
            )).join();
            assertBooleanResponseCompletedNormally(deleteWingResponse);
            assertTrue(deleteWingResponse.wasSuccessful());
        }
    }

    private void testFleetLevelEndpoints(final long fleetID) {
        final CompletableFuture<Void> updateFleetFuture = client.sendRequest(new FleetUpdateRequest(
            fleetID, accessToken, new FleetUpdateBuilder(true, "The fleet is a test fleet").build()
        )).thenAcceptAsync(response -> {
            assertBooleanResponseCompletedNormally(response);
            assertTrue(response.wasSuccessful());
        });

        final CompletableFuture<Void> fleetInfoFuture = client.sendRequest(
            new FleetInformationRequest(accessToken, fleetID)
        ).thenAcceptAsync(fleetResponse -> {
            final Fleet fleetInfo = assertResponseExistsAndGet(fleetResponse);
            assertNotNull(fleetInfo);
        });

        final CompletableFuture<Void> fleetMembersFuture = client.sendRequest(
            new FleetMembersRequest(accessToken, fleetID)
        ).thenAcceptAsync(response -> {
            final ImmutableList<FleetMember> list = assertResponseExistsAndGet(response);
            assertTrue(list.size() > 0);
            assertEquals(
                1,
                list.stream()
                    .filter(fleetMember -> fleetMember.getCharacterID() == characterID)
                    .collect(Collectors.toList())
                    .size()
            );
        });

        CompletableFuture.allOf(
            updateFleetFuture,
            fleetInfoFuture,
            fleetMembersFuture
        ).join();
    }
}