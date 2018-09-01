package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.industry.FacilityImpl;

import java.util.Optional;

/**
 * Represents an industry facility.
 */
@JsonDeserialize(as = FacilityImpl.class)
public interface Facility {
    /**
     * Get the unique ID for this facility.
     *
     * @return the ID
     */
    long getID();

    /**
     * Get the ID of the owner of this facility.
     *
     * @return the owner ID
     */
    int getOwnerID();

    /**
     * Get the ID of the region where this facility is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the region ID
     * @see gbsio.esiclient.api.domain.response.universe.Region
     */
    int getRegionID();

    /**
     * Get the ID of the solar system where this facility is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Get the tax rate for this structure.
     *
     * @return the tax rate, or absent if no tax rate is specified
     */
    Optional<Float> getTaxRate();

    /**
     * Get the ID of the type of facility.
     *
     * @return the facility type ID
     */
    int getFacilityTypeID();
}
