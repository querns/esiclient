package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.MiningObserver;

import java.time.LocalDate;

public class MiningObserverImpl implements MiningObserver {
    private final LocalDate lastUpdatedDate;
    private final long ID;
    private final ObserverType type;

    MiningObserverImpl(
        @JsonProperty(value = "last_updated", required = true)
        final LocalDate lastUpdatedDate,
        @JsonProperty(value = "observer_id", required = true)
        final long id,
        @JsonProperty(value = "observer_type", required = true)
        final ObserverType type
    ) {
        this.lastUpdatedDate = lastUpdatedDate;
        ID = id;
        this.type = type;
    }

    @Override
    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public ObserverType getType() {
        return type;
    }
}
