package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.Constellation;

public class ConstellationImpl implements Constellation {
    private final int regionID;
    private final ImmutableList<Integer> solarSystemIDs;
    private final int ID;
    private final String name;
    private final Coordinates position;

    ConstellationImpl(
        @JsonProperty(value = "region_id", required = true)
        final int regionID,
        @JsonProperty(value = "systems", required = true)
        final ImmutableList<Integer> solarSystemIDs,
        @JsonProperty(value = "constellation_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "position", required = true)
        final Coordinates position
    ) {
        this.regionID = regionID;
        this.solarSystemIDs = solarSystemIDs;
        ID = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public int getRegionID() {
        return regionID;
    }

    @Override
    public ImmutableList<Integer> getSolarSystemIDs() {
        return solarSystemIDs;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinates getPosition() {
        return position;
    }
}
