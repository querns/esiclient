package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.api.domain.response.universe.Moon;

public class MoonImpl implements Moon {
    private final int solarSystemID;
    private final int ID;
    private final String name;
    private final Coordinates position;

    MoonImpl(
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "moon_id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "position", required = true)
        final Coordinates position
    ) {
        this.solarSystemID = solarSystemID;
        ID = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
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
