package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.market.AdjustedPriceDataImpl;

import java.util.Optional;

/**
 * Represents price data used by CCP to calculate things like industry job cost
 * and bounty payments.
 */
@JsonDeserialize(as = AdjustedPriceDataImpl.class)
public interface AdjustedPriceData {
    /**
     * Get the price data CCP uses to calculate industry job costs for this item
     * type.
     *
     * @return the adjusted price
     */
    Optional<Double> getAdjustedPrice();

    /**
     * Get the average price, game-wide, for this item type.
     *
     * @return the average price
     */
    Optional<Double> getAveragePrice();

    /**
     * Get the ID of the item type this price data is for.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();
}
