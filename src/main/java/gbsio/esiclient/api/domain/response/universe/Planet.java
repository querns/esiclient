package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.internal.domain.response.universe.PlanetImpl;

/**
 * Represents information about a planetary body in the Eve universe.
 */
@JsonDeserialize(as = PlanetImpl.class)
public interface Planet extends CelestialObject {
    /**
     * Gets the ID of the solar system containing this planet.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the ID of the item type describing this planet.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     */
    int getItemTypeID();

    /**
     * Gets the unique ID for this planet.
     *
     * @return the planet ID
     */
    int getID();
}
