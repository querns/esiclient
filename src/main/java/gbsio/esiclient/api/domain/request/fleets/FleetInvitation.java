package gbsio.esiclient.api.domain.request.fleets;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import gbsio.esiclient.api.domain.common.fleets.Role;

import java.util.Optional;

/**
 * Represents information required to invite a character to a fleet.
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public interface FleetInvitation extends HierarchyAssignment {
    /**
     * Gets the ID of the character to invite to fleet.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     */
    @JsonGetter("character_id")
    int getCharacterID();

    /**
     * Creates a fleet invitation that adds a squad member to any available wing
     * and squad.
     *
     * @param characterID the ID of the character to add
     * @return a fleet invitation
     */
    @SuppressWarnings("unused")
    static FleetInvitation squadMember(int characterID) {
        return new FleetInvitationImpl(characterID, Role.SQUAD_MEMBER, null, null);
    }

    /**
     * Creates a fleet invitation that adds a squad member to a specific wing
     * and squad.
     *
     * @param characterID the ID of the character to add
     * @param squadID the ID of the squad to add the character to
     * @param wingID the ID of the wing to add the character to
     * @return a fleet invitation
     */
    @SuppressWarnings("unused")
    static FleetInvitation squadMember(int characterID, long squadID, long wingID) {
        return new FleetInvitationImpl(characterID, Role.SQUAD_MEMBER, squadID, wingID);
    }

    /**
     * Creates a fleet invitation that assigns a squad commander.
     *
     * @param characterID the ID of the character to assign
     * @param squadID the ID of the squad to assume command of
     * @param wingID the ID of the wing the squad is in
     * @return a fleet invitation
     */
    @SuppressWarnings("unused")
    static FleetInvitation squadCommander(int characterID, long squadID, long wingID) {
        return new FleetInvitationImpl(characterID, Role.SQUAD_COMMANDER, squadID, wingID);
    }

    /**
     * Creates a fleet invitation that assigns a wing commander.
     *
     * @param characterID the ID of the character to assign
     * @param wingID the ID of the wing to assume command of
     * @return a fleet invitation
     */
    @SuppressWarnings("unused")
    static FleetInvitation wingCommander(int characterID, long wingID) {
        return new FleetInvitationImpl(characterID, Role.WING_COMMANDER, null, wingID);
    }

    /**
     * Creates a fleet invitation that assigns a fleet commander.
     * @param characterID the ID of the character to assign
     * @return a fleet invitation
     */
    @SuppressWarnings("unused")
    static FleetInvitation fleetCommander(int characterID) {
        return new FleetInvitationImpl(characterID, Role.FLEET_COMMANDER, null, null);
    }

    class FleetInvitationImpl implements FleetInvitation {
        private final int characterID;
        private final Role role;
        private final Long squadID;
        private final Long wingID;

        FleetInvitationImpl(final int characterID, final Role role, final Long squadID, final Long wingID) {
            this.characterID = characterID;
            this.role = role;
            this.squadID = squadID;
            this.wingID = wingID;
        }

        @Override
        public int getCharacterID() {
            return characterID;
        }

        @Override
        public Role getRole() {
            return role;
        }

        @Override
        public Optional<Long> getSquadID() {
            return Optional.ofNullable(squadID);
        }

        @Override
        public Optional<Long> getWingID() {
            return Optional.ofNullable(wingID);
        }
    }
}
