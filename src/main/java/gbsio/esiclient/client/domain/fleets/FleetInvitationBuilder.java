package gbsio.esiclient.client.domain.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.request.fleets.FleetInvitation;
import gbsio.esiclient.client.validation.fleets.HierarchyAssignmentValidator;

import java.util.Optional;

final public class FleetInvitationBuilder {
    private int characterID;
    private Role role;
    private Long squadID;
    private Long wingID;

    @SuppressWarnings("WeakerAccess")
    public FleetInvitationBuilder(final int characterID, final Role role) {
        this.characterID = characterID;
        this.role = role;
    }

    @SuppressWarnings("unused")
    public FleetInvitationBuilder() {
    }

    @SuppressWarnings("unused")
    public FleetInvitationBuilder(final int characterID, final Role role, final Long squadID, final Long wingID) {
        this(characterID, role);
        this.squadID = squadID;
        this.wingID = wingID;
    }

    @SuppressWarnings("unused")
    public FleetInvitationBuilder setCharacterID(final int characterID) {
        this.characterID = characterID;
        return this;
    }

    @SuppressWarnings("unused")
    public FleetInvitationBuilder setRole(final Role role) {
        this.role = role;
        return this;
    }

    @SuppressWarnings("unused")
    public FleetInvitationBuilder setSquadID(final Long squadID) {
        this.squadID = squadID;
        return this;
    }

    @SuppressWarnings("unused")
    public FleetInvitationBuilder setWingID(final Long wingID) {
        this.wingID = wingID;
        return this;
    }

    public FleetInvitation build() {
        final FleetInvitation fleetInvitation = new FleetInvitationImpl(characterID, role, squadID, wingID);
        HierarchyAssignmentValidator.validate(fleetInvitation);
        Preconditions.checkArgument(fleetInvitation.getCharacterID() > 0);

        return fleetInvitation;
    }

    static class FleetInvitationImpl implements FleetInvitation {
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
