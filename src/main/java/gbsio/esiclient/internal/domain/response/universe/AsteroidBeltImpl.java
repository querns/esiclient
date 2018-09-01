package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.AsteroidBelt;

public class AsteroidBeltImpl implements AsteroidBelt {
    private final int solarSystemID;
    private final String name;
    private final Coordinates position;

    AsteroidBeltImpl(
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "position", required = true)
        final Coordinates position
    ) {
        this.solarSystemID = solarSystemID;
        this.name = name;
        this.position = position;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
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
