package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.market.OrderImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents common information for all market orders.
 */
@JsonDeserialize(as = OrderImpl.class)
public interface Order {
    /**
     * Gets the length of time the order is valid.
     *
     * @return a length of time in days
     */
    int getDuration();

    /**
     * Gets whether or not the order was a buy order.
     *
     * @return true if the order was a buy order
     */
    Optional<Boolean> isBuyOrder();

    /**
     * Gets the date the order was issued.
     *
     * @return the issue date
     */
    ZonedDateTime getIssueDate();

    /**
     * Gets the ID of the location of the order.
     *
     * This can be a structure or station.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the location ID
     * @see gbsio.esiclient.api.domain.response.universe.Structure
     * @see gbsio.esiclient.api.domain.response.universe.Station
     */
    long getLocationID();

    /**
     * Gets the minimum volume necessary to sell to a buy order.
     *
     * @return the min volume
     */
    Optional<Integer> getMinVolume();

    /**
     * Gets the unique ID for this order.
     *
     * @return the ID
     */
    long getOrderID();

    /**
     * Gets the cost per unit for this order.
     *
     * @return the price
     */
    double getPrice();

    /**
     * Gets the range of a buy order.
     *
     * @return the range
     */
    OrderRange getRange();

    /**
     * Gets the item type ID for sale or for bid.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Gets the number of items still for sale or still on offer.
     *
     * @return the remaining volume
     */
    int getRemainingVolume();

    /**
     * Gets the original amount of items on offer or on sale.
     *
     * @return the total volume
     */
    int getTotalVolume();
}
