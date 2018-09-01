package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.industry.CostIndexDataImpl;
import gbsio.esiclient.internal.domain.response.industry.CostIndexImpl;

/**
 * Represents data about system cost indexes.
 *
 * System cost indexes act as a multiplier on fees charged by industry
 * facilities.
 */
@JsonDeserialize(as = CostIndexDataImpl.class)
public interface CostIndexData {
    /**
     * Gets the cost index data for each type of industry activity.
     *
     * @return the cost index data
     */
    ImmutableList<CostIndex> getCostIndexes();

    /**
     * Gets the ID of the solar system where this data originated.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Represents data about a single type of activity performed in a solar
     * system.
     */
    @JsonDeserialize(as = CostIndexImpl.class)
    interface CostIndex {
        /**
         * Gets the type of activity this data represents.
         *
         * @return the activity
         */
        IndustryActivity getActivity();

        /**
         * Gets the cost factor for this type of activity.
         *
         * @return the cost factor
         */
        float getCostFactor();
    }

}
