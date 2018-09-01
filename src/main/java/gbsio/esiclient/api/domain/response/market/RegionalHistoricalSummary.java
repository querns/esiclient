package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.market.RegionalHistoricalSummaryImpl;

import java.time.LocalDate;

/**
 * Represents summary information about the history of trade in a region for a
 * single item type.
 */
@JsonDeserialize(as = RegionalHistoricalSummaryImpl.class)
public interface RegionalHistoricalSummary {
    /**
     * Get the average price at which this item moved.
     *
     * @return the average price
     */
    double getAverage();

    /**
     * Get the date of this history entry.
     *
     * @return the date
     */
    LocalDate getDate();

    /**
     * Get the highest price at which this item moved.
     *
     * @return the highest price
     */
    double getHighest();

    /**
     * Get the lowest price at which this item moved.
     *
     * @return the lowest price
     */
    double getLowest();

    /**
     * Get the number of orders for this item.
     *
     * @return the order count
     */
    long getOrderCount();

    /**
     * Get the total number of units of this item moved.
     *
     * @return the total volume
     */
    long getVolume();
}
