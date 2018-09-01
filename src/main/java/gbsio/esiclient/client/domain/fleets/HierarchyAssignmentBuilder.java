package gbsio.esiclient.client.domain.fleets;

import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.request.fleets.HierarchyAssignment;

import java.util.Optional;

@SuppressWarnings("unused")
final public class HierarchyAssignmentBuilder {
    private Role role;
    private Long squadID;
    private Long wingID;

    @SuppressWarnings("unused")
    public HierarchyAssignmentBuilder(final Role role) {
        this.role = role;
    }

    @SuppressWarnings("unused")
    public HierarchyAssignmentBuilder(final Role role, final Long squadID, final Long wingID) {
        this.role = role;
        this.squadID = squadID;
        this.wingID = wingID;
    }

    @SuppressWarnings("unused")
    public HierarchyAssignmentBuilder setRole(final Role role) {
        this.role = role;
        return this;
    }

    @SuppressWarnings("unused")
    public HierarchyAssignmentBuilder setSquadID(final Long squadID) {
        this.squadID = squadID;
        return this;
    }

    @SuppressWarnings("unused")
    public HierarchyAssignmentBuilder setWingID(final Long wingID) {
        this.wingID = wingID;
        return this;
    }

    @SuppressWarnings("unused")
    public HierarchyAssignment build() {
        return new HierarchyAssignmentImpl(role, squadID, wingID);
    }

    static class HierarchyAssignmentImpl implements HierarchyAssignment {
        private final Role role;
        private final Long squadID;
        private final Long wingID;

        HierarchyAssignmentImpl(final Role role, final Long squadID, final Long wingID) {
            this.role = role;
            this.squadID = squadID;
            this.wingID = wingID;
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
