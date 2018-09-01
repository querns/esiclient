package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.MemberTrackingData;

import java.time.ZonedDateTime;
import java.util.Optional;

public class MemberTrackingDataImpl implements MemberTrackingData {
    private final Integer baseID;
    private final int characterID;
    private final Long locationID;
    private final ZonedDateTime logoffDate;
    private final ZonedDateTime loginDate;
    private final Integer shipTypeID;
    private final ZonedDateTime startDate;

    MemberTrackingDataImpl(
        @JsonProperty("base_id")
        final Integer baseID,
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty("location_id")
        final Long locationID,
        @JsonProperty("logoff_date")
        final ZonedDateTime logoffDate,
        @JsonProperty("logon_date")
        final ZonedDateTime loginDate,
        @JsonProperty("ship_type_id")
        final Integer shipTypeID,
        @JsonProperty("start_date")
        final ZonedDateTime startDate
    ) {
        this.baseID = baseID;
        this.characterID = characterID;
        this.locationID = locationID;
        this.logoffDate = logoffDate;
        this.loginDate = loginDate;
        this.shipTypeID = shipTypeID;
        this.startDate = startDate;
    }

    @Override
    public Optional<Integer> getBaseID() {
        return Optional.ofNullable(baseID);
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public Optional<Long> getLocationID() {
        return Optional.ofNullable(locationID);
    }

    @Override
    public Optional<ZonedDateTime> getLogoffDate() {
        return Optional.ofNullable(logoffDate);
    }

    @Override
    public Optional<ZonedDateTime> getLoginDate() {
        return Optional.ofNullable(loginDate);
    }

    @Override
    public Optional<Integer> getShipTypeID() {
        return Optional.ofNullable(shipTypeID);
    }

    @Override
    public Optional<ZonedDateTime> getStartDate() {
        return Optional.ofNullable(startDate);
    }
}
