package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.internal.domain.response.universe.ConstellationImpl;

/**
 * Represents a constellation of solar systems in the Eve universe.
 */
@JsonDeserialize(as = ConstellationImpl.class)
public interface Constellation extends CelestialObject {
    /**
     * Gets the ID of the region containing this constellation.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the region ID
     * @see Region
     */
    int getRegionID();

    /**
     * Gets the list of IDs of solar systems contained by this constellation.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 1 or more solar system IDs
     * @see SolarSystem
     */
    ImmutableList<Integer> getSolarSystemIDs();

    /**
     * Gets the unique ID for this constellation.
     *
     * @return the constellation ID
     */
    int getID();
}
