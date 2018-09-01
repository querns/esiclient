package gbsio.esiclient.internal.domain.response.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.location.Location;

import java.util.Optional;

public class LocationImpl implements Location {
    private final int solarSystemID;
    private final Integer stationID;
    private final Long structureID;

    LocationImpl(
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty("station_id")
        final Integer stationID,
        @JsonProperty("structure_id")
        final Long structureID
    ) {
        this.solarSystemID = solarSystemID;
        this.stationID = stationID;
        this.structureID = structureID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public Optional<Integer> getStationID() {
        return Optional.ofNullable(stationID);
    }

    @Override
    public Optional<Long> getStructureID() {
        return Optional.ofNullable(structureID);
    }
}
