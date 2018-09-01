package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.corporations.FacilityImpl;

/**
 * Represents a facility owned by a corporation.
 */
@JsonDeserialize(as = FacilityImpl.class)
public interface Facility {
    /**
     * Get the unique ID for this facility
     *
     * @return the facility's ID
     */
    long getID();

    /**
     * Get the solar system ID for this system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Get the item type ID for this facility.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getTypeID();
}
