package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SolarSystem;

public class PlanetDataImpl implements SolarSystem.PlanetData {
    private final ImmutableList<Integer> asteroidBeltIDs;
    private final ImmutableList<Integer> moonIDs;
    private final int planetID;

    PlanetDataImpl(
        @JsonProperty("asteroid_belts")
        final ImmutableList<Integer> asteroidBeltIDs,
        @JsonProperty("moons")
        final ImmutableList<Integer> moonIDs,
        @JsonProperty(value = "planet_id", required = true)
        final int planetID
    ) {
        this.asteroidBeltIDs = MoreObjects.firstNonNull(asteroidBeltIDs, ImmutableList.of());
        this.moonIDs = MoreObjects.firstNonNull(moonIDs, ImmutableList.of());
        this.planetID = planetID;
    }

    @Override
    public ImmutableList<Integer> getAsteroidBeltIDs() {
        return asteroidBeltIDs;
    }

    @Override
    public ImmutableList<Integer> getMoonIDs() {
        return moonIDs;
    }

    @Override
    public int getPlanetID() {
        return planetID;
    }
}
