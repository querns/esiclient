package gbsio.esiclient.api.domain.response.fleets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.internal.domain.response.fleets.CurrentFleetImpl;

import java.util.Optional;

/**
 * Represents information about a character's current membership in a fleet, if
 * applicable.
 */
@JsonDeserialize(as = CurrentFleetImpl.class)
public interface CurrentFleet {
    /**
     * Get the unique ID for this fleet.
     *
     * @return the fleet ID
     */
    long getID();

    /**
     * Get the role for this character in the fleet.
     *
     * @return the role
     */
    Role getRole();

    /**
     * Get the ID of the squad the character is occupying.
     *
     * @return the squad ID
     */
    Optional<Long> getSquadID();

    /**
     * Get the ID of the wing the character is occupying.
     *
     * @return the wing ID
     */
    Optional<Long> getWingID();

}
