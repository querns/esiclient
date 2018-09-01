package gbsio.esiclient.api.domain.response.insurance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.insurance.InsuranceLevelImpl;
import gbsio.esiclient.internal.domain.response.insurance.InsurancePriceDataImpl;

/**
 * Represents data about the insurance levels available for a ship type.
 */
@JsonDeserialize(as = InsurancePriceDataImpl.class)
public interface InsurancePriceData {
    /**
     * Gets the levels of insurance available for this ship type.
     *
     * @return up to 6 levels of insurance
     */
    ImmutableList<InsuranceLevel> getLevels();

    /**
     * Get the item type ID for the ship being described by this data.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID for the ship
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getShipItemTypeID();

    /**
     * Represents data about a specific level of insurance.
     */
    @JsonDeserialize(as = InsuranceLevelImpl.class)
    interface InsuranceLevel {
        /**
         * Get the out-of-pocket cost for insuring a ship at this level.
         *
         * @return the cost
         */
        float getCost();

        /**
         * Get the localized name for this tier of insurance.
         *
         * @return the name
         */
        String getName();

        /**
         * Get the payout awarded when the insured ship is destroyed.
         *
         * @return the payout
         */
        float getPayout();
    }
}
