package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.market.RegionalHistoricalSummary;

import java.time.LocalDate;

public class RegionalHistoricalSummaryImpl implements RegionalHistoricalSummary {
    private final double average;
    private final LocalDate date;
    private final double highest;
    private final double lowest;
    private final long orderCount;
    private final long volume;

    RegionalHistoricalSummaryImpl(
        @JsonProperty(value = "average", required = true)
        final double average,
        @JsonProperty(value = "date", required = true)
        final LocalDate date,
        @JsonProperty(value = "highest", required = true)
        final double highest,
        @JsonProperty(value = "lowest", required = true)
        final double lowest,
        @JsonProperty(value = "order_count", required = true)
        final long orderCount,
        @JsonProperty(value = "volume", required = true)
        final long volume
    ) {
        this.average = average;
        this.date = date;
        this.highest = highest;
        this.lowest = lowest;
        this.orderCount = orderCount;
        this.volume = volume;
    }

    @Override
    public double getAverage() {
        return average;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public double getHighest() {
        return highest;
    }

    @Override
    public double getLowest() {
        return lowest;
    }

    @Override
    public long getOrderCount() {
        return orderCount;
    }

    @Override
    public long getVolume() {
        return volume;
    }
}
