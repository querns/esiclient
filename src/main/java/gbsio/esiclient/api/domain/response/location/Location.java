package gbsio.esiclient.api.domain.response.location;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.location.LocationImpl;

import java.util.Optional;

/**
 * Represents data about a character's current location in space.
 */
@JsonDeserialize(as = LocationImpl.class)
public interface Location {
    /**
     * Gets the ID of the solar system where the character currently is.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the ID of the station the character is docked at, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the station ID
     * @see gbsio.esiclient.api.domain.response.universe.Station
     */
    Optional<Integer> getStationID();

    /**
     * Gets the ID of the structure the character is docked at, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the structure ID
     * @see gbsio.esiclient.api.domain.response.universe.Structure
     */
    Optional<Long> getStructureID();
}
