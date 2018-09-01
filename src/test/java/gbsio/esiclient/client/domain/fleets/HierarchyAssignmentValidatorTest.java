package gbsio.esiclient.client.domain.fleets;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.request.fleets.FleetInvitation;
import gbsio.esiclient.client.validation.fleets.HierarchyAssignmentValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HierarchyAssignmentValidatorTest {
    private static final int CHARACTER_ID = 12345;
    private static final Long VALID_POSITION_ID = 1L;
    private static final Long INVALID_POSITION_ID = -1L;

    @Test
    void validate() {
        List<FleetInvitation> errorCases = ImmutableList.of(
            // Malformed arguments
//            new FleetInvitationImpl(-1, Role.FLEET_COMMANDER, null, null),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.FLEET_COMMANDER, INVALID_POSITION_ID, null),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.FLEET_COMMANDER, null, INVALID_POSITION_ID),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.UNKNOWN, null, null),

            // Fleet Commander
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.FLEET_COMMANDER, VALID_POSITION_ID, null),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.FLEET_COMMANDER, null, VALID_POSITION_ID),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.FLEET_COMMANDER, VALID_POSITION_ID, VALID_POSITION_ID),

            // Wing Commander (back my crowd funding Ponzi scheme)
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.WING_COMMANDER, VALID_POSITION_ID, VALID_POSITION_ID),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.WING_COMMANDER, null, null),

            // Squad Commander
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.SQUAD_COMMANDER, VALID_POSITION_ID, null),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.SQUAD_COMMANDER, null, VALID_POSITION_ID),

            // Squad Member
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.SQUAD_MEMBER, VALID_POSITION_ID, null),
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, Role.SQUAD_MEMBER, null, VALID_POSITION_ID)
        );

        errorCases.forEach(invitation -> assertThrows(
            IllegalArgumentException.class,
            () -> HierarchyAssignmentValidator.validate(invitation))
        );
    }

    @Test
    void validateStrictSquadMember() {
        assertThrows(
            IllegalArgumentException.class,
            () -> HierarchyAssignmentValidator.validate(FleetInvitation.squadMember(CHARACTER_ID), true)
        );

        HierarchyAssignmentValidator.validate(FleetInvitation.squadMember(CHARACTER_ID, VALID_POSITION_ID, VALID_POSITION_ID));
    }
}