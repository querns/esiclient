package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.SolarSystem;

import java.util.Optional;

public class SolarSystemImpl implements SolarSystem {
    private final int constellationID;
    private final ImmutableList<PlanetData> planetData;
    private final String securityClass;
    private final float securityStatus;
    private final Integer starID;
    private final ImmutableList<Integer> stargateIDs;
    private final ImmutableList<Integer> stationIDs;
    private final int ID;
    private final String name;
    private final Coordinates position;

    SolarSystemImpl(
        @JsonProperty(value = "constellation_id", required = true)
        final int constellationID,
        @JsonProperty("planets")
        final ImmutableList<PlanetData> planetData,
        @JsonProperty("security_class")
        final String securityClass,
        @JsonProperty(value = "security_status", required = true)
        final float securityStatus,
        @JsonProperty("star_id")
        final Integer starID,
        @JsonProperty("stargates")
        final ImmutableList<Integer> stargateIDs,
        @JsonProperty("stations")
        final ImmutableList<Integer> stationIDs,
        @JsonProperty(value = "system_id", required = true)
        final int ID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "position", required = true)
        final Coordinates position
    ) {
        this.constellationID = constellationID;
        this.planetData = MoreObjects.firstNonNull(planetData, ImmutableList.of());
        this.securityClass = securityClass;
        this.securityStatus = securityStatus;
        this.starID = starID;
        this.stargateIDs = MoreObjects.firstNonNull(stargateIDs, ImmutableList.of());
        this.stationIDs = MoreObjects.firstNonNull(stationIDs, ImmutableList.of());
        this.ID = ID;
        this.name = name;
        this.position = position;
    }

    @Override
    public int getConstellationID() {
        return constellationID;
    }

    public ImmutableList<PlanetData> getPlanets() {
        return planetData;
    }

    @Override
    public Optional<String> getSecurityClass() {
        return Optional.ofNullable(securityClass);
    }

    @Override
    public float getSecurityStatus() {
        return securityStatus;
    }

    @Override
    public Optional<Integer> getStarID() {
        return Optional.ofNullable(starID);
    }

    @Override
    public ImmutableList<Integer> getStargateIDs() {
        return stargateIDs;
    }

    @Override
    public ImmutableList<Integer> getStationIDs() {
        return stationIDs;
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
