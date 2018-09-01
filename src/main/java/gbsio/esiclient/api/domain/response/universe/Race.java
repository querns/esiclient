package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.RaceImpl;

/**
 * Represents a race that a player character or NPC belongs to.
 */
@JsonDeserialize(as = RaceImpl.class)
public interface Race {
    /**
     * Gets the ID of the alliance associated with this race.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    int getAllianceID();

    /**
     * Gets the description for this race.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the name of this race.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the unique ID for this race.
     *
     * @return the ID
     */
    int getID();
}
