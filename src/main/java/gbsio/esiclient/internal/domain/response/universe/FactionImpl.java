package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.Faction;

import java.util.Optional;

public class FactionImpl implements Faction {
    private final Integer corporationID;
    private final String description;
    private final int ID;
    private final boolean unique;
    private final Integer militiaCorporationID;
    private final String name;
    private final float sizeFactor;
    private final Integer solarSystemID;
    private final int stationCount;
    private final int stationSystemCount;

    FactionImpl(
        @JsonProperty("corporation_id")
        final Integer corporationID,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "faction_id", required = true)
        final int id,
        @JsonProperty(value = "is_unique", required = true)
        final boolean unique,
        @JsonProperty(value = "militia_corporation_id")
        final Integer militiaCorporationID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "size_factor", required = true)
        final float sizeFactor,
        @JsonProperty(value = "solar_system_id")
        final Integer solarSystemID,
        @JsonProperty(value = "station_count", required = true)
        final int stationCount,
        @JsonProperty(value = "station_system_count", required = true)
        final int stationSystemCount
    ) {
        this.corporationID = corporationID;
        this.description = description;
        ID = id;
        this.unique = unique;
        this.militiaCorporationID = militiaCorporationID;
        this.name = name;
        this.sizeFactor = sizeFactor;
        this.solarSystemID = solarSystemID;
        this.stationCount = stationCount;
        this.stationSystemCount = stationSystemCount;
    }

    @Override
    public Optional<Integer> getCorporationID() {
        return Optional.ofNullable(corporationID);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }

    @Override
    public Optional<Integer> getMilitiaCorporationID() {
        return Optional.ofNullable(militiaCorporationID);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getSizeFactor() {
        return sizeFactor;
    }

    @Override
    public Optional<Integer> getSolarSystemID() {
        return Optional.ofNullable(solarSystemID);
    }

    @Override
    public int getStationCount() {
        return stationCount;
    }

    @Override
    public int getStationSystemCount() {
        return stationSystemCount;
    }
}
