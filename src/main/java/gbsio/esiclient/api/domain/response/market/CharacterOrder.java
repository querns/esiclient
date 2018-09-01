package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.market.CharacterOrderImpl;

import java.util.Optional;

/**
 * Represents a market order containing additional information that only the
 * owned concern (character or corporation) could know.
 */
@JsonDeserialize(as = CharacterOrderImpl.class)
public interface CharacterOrder extends Order {
    /**
     * Gets the amount of ISK in escrow for a buy order made with Margin
     * Trading.
     *
     * @return the escrow amount
     */
    Optional<Double> getEscrow();

    /**
     * Gets the reason why this order was completed.
     *
     * @return the completion reason
     */
    Optional<HistoricalOrderState> getState();

    /**
     * Gets whether or not this order was made on behalf of a corporation.
     *
     * Only relevant for character-scope orders.
     *
     * @return true if the order is a corporate market order
     */
    Optional<Boolean> isCorporateOrder();

    /**
     * Gets the ID of the region where this order was placed.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the region ID
     * @see gbsio.esiclient.api.domain.response.universe.Region
     */
    Optional<Integer> getRegionID();


}
