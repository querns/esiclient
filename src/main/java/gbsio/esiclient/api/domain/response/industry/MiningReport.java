package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.industry.MiningReportImpl;

import java.time.LocalDate;

/**
 * Represents statistics about mining performed by a character in the last 30
 * days.
 */
@JsonDeserialize(as = MiningReportImpl.class)
public interface MiningReport {
    /**
     * Gets the date when the mining activity was performed.
     *
     * @return the date
     */
    LocalDate getDate();

    /**
     * Get the number of units of material that was mined.
     *
     * @return the mined quantity
     */
    long getQuantity();

    /**
     * Gets the ID of the solar system where this mining activity occurred.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the item type ID of the material that was mined.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID of the mined material
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getMaterialItemTypeID();
}
