package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.SystemJumpDataImpl;

/**
 * Represents data about the number of ship jumps performed in the last hour.
 * @link https://esi.evetech.net/ui/?version=_latest#/Universe/get_universe_system_jumps
 */
@JsonDeserialize(as = SystemJumpDataImpl.class)
public interface SystemJumpData {
    /**
     * Gets the number of jumps performed this hour.
     *
     * @return the jump count
     */
    int getJumps();

    /**
     * Gets the ID of the solar system this data pertains to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();
}
