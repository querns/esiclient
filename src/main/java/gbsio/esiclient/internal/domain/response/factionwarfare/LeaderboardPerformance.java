package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

@JsonDeserialize(as = LeaderboardPerformance.class)
public class LeaderboardPerformance<T> implements HistoricalPerformance<T> {
    private final T previousWeek;
    private final T total;
    private final T previousDay;

    LeaderboardPerformance(
        @JsonProperty(value = "last_week", required = true)
        final T previousWeek,
        @JsonProperty(value = "active_total", required = true)
        final T total,
        @JsonProperty(value = "yesterday", required = true)
        final T previousDay
    ) {
        this.previousWeek = previousWeek;
        this.total = total;
        this.previousDay = previousDay;
    }

    @Override
    public T getPreviousWeek() {
        return previousWeek;
    }

    @Override
    public T getTotal() {
        return total;
    }

    @Override
    public T getPreviousDay() {
        return previousDay;
    }
}
