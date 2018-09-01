package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.planetaryinteraction.ColonySummary;

import java.time.ZonedDateTime;

public class ColonySummaryImpl implements ColonySummary {
    private final ZonedDateTime lastUpdateDate;
    private final int pinCount;
    private final int ownerID;
    private final int planetID;
    private final PlanetType planetType;
    private final int solarSystemID;
    private final int upgradeLevel;

    ColonySummaryImpl(
        @JsonProperty(value = "last_update", required = true)
        final ZonedDateTime lastUpdateDate,
        @JsonProperty(value = "num_pins", required = true)
        final int pinCount,
        @JsonProperty(value = "owner_id", required = true)
        final int ownerID,
        @JsonProperty(value = "planet_id", required = true)
        final int planetID,
        @JsonProperty(value = "planet_type", required = true)
        final PlanetType planetType,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "upgrade_level", required = true)
        final int upgradeLevel
    ) {
        this.lastUpdateDate = lastUpdateDate;
        this.pinCount = pinCount;
        this.ownerID = ownerID;
        this.planetID = planetID;
        this.planetType = planetType;
        this.solarSystemID = solarSystemID;
        this.upgradeLevel = upgradeLevel;
    }

    @Override
    public ZonedDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Override
    public int getPinCount() {
        return pinCount;
    }

    @Override
    public int getOwnerID() {
        return ownerID;
    }

    @Override
    public int getPlanetID() {
        return planetID;
    }

    @Override
    public PlanetType getPlanetType() {
        return planetType;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public int getUpgradeLevel() {
        return upgradeLevel;
    }
}
