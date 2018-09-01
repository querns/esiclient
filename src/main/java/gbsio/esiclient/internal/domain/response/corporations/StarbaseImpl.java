package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.Starbase;

import java.time.ZonedDateTime;
import java.util.Optional;

public class StarbaseImpl implements Starbase {
    private final Integer moonID;
    private final ZonedDateTime onlinedSince;
    private final ZonedDateTime reinforcedUntil;
    private final long starbaseID;
    private final StarbaseState state;
    private final int solarSystemID;
    private final int itemTypeID;
    private final ZonedDateTime unanchorAt;

    StarbaseImpl(
        @JsonProperty("moon_id")
        final Integer moonID,
        @JsonProperty("onlined_since")
        final ZonedDateTime onlinedSince,
        @JsonProperty("reinforced_until")
        final ZonedDateTime reinforcedUntil,
        @JsonProperty(value = "starbase_id", required = true)
        final long starbaseID,
        @JsonProperty("state")
        final StarbaseState state,
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID,
        @JsonProperty("unanchor_at")
        final ZonedDateTime unanchorAt
    ) {
        this.moonID = moonID;
        this.onlinedSince = onlinedSince;
        this.reinforcedUntil = reinforcedUntil;
        this.starbaseID = starbaseID;
        this.state = state;
        this.solarSystemID = solarSystemID;
        this.itemTypeID = itemTypeID;
        this.unanchorAt = unanchorAt;
    }

    @Override
    public Optional<Integer> getMoonID() {
        return Optional.ofNullable(moonID);
    }

    @Override
    public Optional<ZonedDateTime> getOnlinedSince() {
        return Optional.ofNullable(onlinedSince);
    }

    @Override
    public Optional<ZonedDateTime> getReinforcedUntil() {
        return Optional.ofNullable(reinforcedUntil);
    }

    @Override
    public long getStarbaseID() {
        return starbaseID;
    }

    @Override
    public Optional<StarbaseState> getState() {
        return Optional.ofNullable(state);
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }

    @Override
    public Optional<ZonedDateTime> getUnanchorAt() {
        return Optional.ofNullable(unanchorAt);
    }
}
