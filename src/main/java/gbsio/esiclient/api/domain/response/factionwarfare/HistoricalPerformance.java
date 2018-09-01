package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.HistoricalPerformanceImpl;

/**
 * Represents information about historical performance in faction warfare.
 */
@JsonDeserialize(as = HistoricalPerformanceImpl.class)
public interface HistoricalPerformance<T> {
    /**
     * Get the performance in the week prior to the API call.
     *
     * @return last week's performance
     */
    T getPreviousWeek();

    /**
     * Get the total performance of the concern at the time of the API call.
     *
     * For leaderboard statistics, this only counts entities that have been
     * enrolled in faction warfare in the last 14 days. Otherwise, all-time
     * performance is measured.
     *
     * @return the total performance
     */
    T getTotal();

    /**
     * Get the performance in the day prior to the API call.
     *
     * @return yesterday's performance
     */
    T getPreviousDay();
}
