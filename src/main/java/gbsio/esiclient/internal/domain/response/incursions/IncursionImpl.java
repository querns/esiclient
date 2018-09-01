package gbsio.esiclient.internal.domain.response.incursions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.incursions.Incursion;

public class IncursionImpl implements Incursion {
    private final int constellationID;
    private final int factionID;
    private final boolean hasBoss;
    private final ImmutableList<Integer> infestedSolarSystems;
    private final float influence;
    private final int stagingSolarSystemID;
    private final State state;
    private final String type;

    IncursionImpl(
        @JsonProperty(value = "constellation_id", required = true)
        final int constellationID,
        @JsonProperty(value = "faction_id", required = true)
        final int factionID,
        @JsonProperty(value = "has_boss", required = true)
        final boolean hasBoss,
        @JsonProperty(value = "infested_solar_systems", required = true)
        final ImmutableList<Integer> infestedSolarSystems,
        @JsonProperty(value = "influence", required = true)
        final float influence,
        @JsonProperty(value = "staging_solar_system_id", required = true)
        final int stagingSolarSystemID,
        @JsonProperty(value = "state", required = true)
        final State state,
        @JsonProperty(value = "type", required = true)
        final String type
    ) {
        this.constellationID = constellationID;
        this.factionID = factionID;
        this.hasBoss = hasBoss;
        this.infestedSolarSystems = MoreObjects.firstNonNull(infestedSolarSystems, ImmutableList.of());
        this.influence = influence;
        this.stagingSolarSystemID = stagingSolarSystemID;
        this.state = state;
        this.type = type;
    }

    @Override
    public int getConstellationID() {
        return constellationID;
    }

    @Override
    public int getFactionID() {
        return factionID;
    }

    public boolean hasBoss() {
        return hasBoss;
    }

    @Override
    public ImmutableList<Integer> getInfestedSolarSystems() {
        return infestedSolarSystems;
    }

    @Override
    public float getInfluence() {
        return influence;
    }

    @Override
    public int getStagingSolarSystemID() {
        return stagingSolarSystemID;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public String getType() {
        return type;
    }
}
