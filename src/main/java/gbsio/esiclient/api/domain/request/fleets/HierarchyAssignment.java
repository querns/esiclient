package gbsio.esiclient.api.domain.request.fleets;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import gbsio.esiclient.api.domain.common.fleets.Role;

import java.util.Optional;

public interface HierarchyAssignment {
    /**
     * Gets the fleet role for the character.
     *
     * @return the fleet role
     */
    @JsonGetter("role")
    Role getRole();

    /**
     * Gets the ID of the squad the fleet member should occupy.
     *
     * @return the squad ID
     */
    @JsonGetter("squad_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Long> getSquadID();

    /**
     * Gets the ID of the wing the fleet member should occupy.
     *
     * @return the wing ID
     */
    @JsonGetter("wing_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Long> getWingID();
}
