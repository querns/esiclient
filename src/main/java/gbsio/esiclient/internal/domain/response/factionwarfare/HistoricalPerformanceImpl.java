package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.HistoricalPerformance;

public class HistoricalPerformanceImpl<T> implements HistoricalPerformance<T> {
    private final T previousWeek;
    private final T total;
    private final T previousDay;

    @SuppressWarnings("unused")
    HistoricalPerformanceImpl(
        @JsonProperty(value = "last_week", required = true)
        final T previousWeek,
        @JsonProperty(value = "total", required = true)
        final T total,
        @JsonProperty(value = "yesterday", required = true)
        final T previousDay
    ) {
        this.previousWeek = previousWeek;
        this.total = total;
        this.previousDay = previousDay;
    }

    HistoricalPerformanceImpl(LeaderboardPerformance<? extends T> delegate) {
        this.previousDay = delegate.getPreviousDay();
        this.total = delegate.getTotal();
        this.previousWeek = delegate.getPreviousWeek();
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
