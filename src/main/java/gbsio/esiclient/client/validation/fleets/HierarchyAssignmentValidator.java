package gbsio.esiclient.client.validation.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.request.fleets.HierarchyAssignment;

public class HierarchyAssignmentValidator {
    public static void validate(HierarchyAssignment assignment) {
        validate(assignment, false);
    }

    public static void validate(HierarchyAssignment assignment, boolean requireSpecificSquadMemberAssignment) throws IllegalArgumentException {
        final Role role = assignment.getRole();
        final boolean squadIDPresent = assignment.getSquadID().isPresent();
        final boolean wingIDPresent = assignment.getWingID().isPresent();

        if (wingIDPresent) {
            Preconditions.checkArgument(assignment.getWingID().get() >= 0, "Wing ID must be a positive integer");
        }

        if (squadIDPresent) {
            Preconditions.checkArgument(assignment.getSquadID().get() >= 0, "Squad ID must be a positive integer");
        }

        switch (role) {
            case UNKNOWN:
                throw new IllegalArgumentException("Role cannot be UNKNOWN");
            case FLEET_COMMANDER:
                Preconditions.checkArgument(
                    !squadIDPresent && !wingIDPresent,
                    "Characters being added as fleet commanders cannot have a squad ID or wing ID set"
                );
                break;
            case WING_COMMANDER:
                Preconditions.checkArgument(!squadIDPresent, "Wing commanders cannot have a squad ID set");
                Preconditions.checkArgument(wingIDPresent, "Wing commanders must have a wing ID set");
                break;
            case SQUAD_COMMANDER:
                Preconditions.checkArgument(
                    wingIDPresent && squadIDPresent,
                    "Squad commanders must have both wing ID and squad ID set"
                );
                break;
            case SQUAD_MEMBER:
                if (requireSpecificSquadMemberAssignment) {
                    Preconditions.checkArgument(
                        wingIDPresent && squadIDPresent,
                        "Squad members must have both wing ID and squad ID present"
                    );
                } else {
                    if ((squadIDPresent && !wingIDPresent) || (!squadIDPresent && wingIDPresent)) {
                        throw new IllegalArgumentException("Squad members must either have both wing ID and squad ID set, or have them both missing");
                    }
                }
        }
    }
}
