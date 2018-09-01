package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.internal.domain.response.universe.StargateImpl;

/**
 * Represents a stargate in New Eden.
 *
 * Stargates allow transit between solar systems.
 */
@JsonDeserialize(as = StargateImpl.class)
public interface Stargate extends CelestialObject {
    /**
     * Gets the ID of the stargate paired to this stargate.
     *
     * @return the stargate ID of the destination
     */
    int getDestinationStargateID();

    /**
     * Gets the ID of the solar system that this stargate provides transit to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the destination solar system ID
     * @see SolarSystem
     */
    int getDestinationSolarSystemID();

    /**
     * Gets the ID of the solar system containing this stargate.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the containing solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the ID of the item type describing this stargate.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     */
    int getItemTypeID();

    /**
     * Gets the unique ID for this stargate.
     *
     * @return the stargate ID
     */
    int getID();
}
