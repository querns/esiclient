package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Schematic;

public class SchematicImpl implements Schematic {
    private final int cycleTime;
    private final String name;

    SchematicImpl(
        @JsonProperty(value = "cycle_time", required = true)
        final int cycleTime,
        @JsonProperty(value = "schematic_name", required = true)
        final String name
    ) {
        this.cycleTime = cycleTime;
        this.name = name;
    }

    @Override
    public int getCycleTime() {
        return cycleTime;
    }

    @Override
    public String getName() {
        return name;
    }
}
