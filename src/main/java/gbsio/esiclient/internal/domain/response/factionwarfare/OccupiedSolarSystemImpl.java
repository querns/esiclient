package gbsio.esiclient.internal.domain.response.factionwarfare;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.factionwarfare.OccupiedSolarSystem;

public class OccupiedSolarSystemImpl implements OccupiedSolarSystem {
    private final OccupationStatus status;
    private final int occupierFactionID;
    private final int ownerFactionID;
    private final int solarSystemID;
    private final int victoryPoints;
    private final int victoryPointThreshold;

    OccupiedSolarSystemImpl(
        @JsonProperty(value = "contested", required = true)
        final OccupationStatus status,
        @JsonProperty(value = "occupier_faction_id", required = true)
        final int occupierFactionID,
        @JsonProperty(value = "owner_faction_id", required = true)
        final int ownerFactionID,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "victory_points", required = true)
        final int victoryPoints,
        @JsonProperty(value = "victory_points_threshold", required = true)
        final int victoryPointThreshold
    ) {
        this.status = status;
        this.occupierFactionID = occupierFactionID;
        this.ownerFactionID = ownerFactionID;
        this.solarSystemID = solarSystemID;
        this.victoryPoints = victoryPoints;
        this.victoryPointThreshold = victoryPointThreshold;
    }

    @Override
    public OccupationStatus getStatus() {
        return status;
    }

    @Override
    public int getOccupierFactionID() {
        return occupierFactionID;
    }

    @Override
    public int getOwnerFactionID() {
        return ownerFactionID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public int getVictoryPointThreshold() {
        return victoryPointThreshold;
    }
}
