package gbsio.esiclient.api.domain.response.fleets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.fleets.SquadImpl;

/**
 * Represents a squad in a fleet.
 *
 * Squads are the second-level grouping device for a fleet. A squad is contained
 * by a wing.
 */
@JsonDeserialize(as = SquadImpl.class)
public interface Squad {
    /**
     * Get the unique ID for this squad.
     *
     * @return the squad ID
     */
    long getID();

    /**
     * Get the user-supplied name for this squad.
     *
     * @return the name
     */
    String getName();
}
