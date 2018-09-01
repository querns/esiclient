package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Region;

import java.util.Optional;

public class RegionImpl implements Region {
    private final ImmutableList<Integer> constellationIDs;
    private final String description;
    private final String name;
    private final int ID;

    RegionImpl(
        @JsonProperty(value = "constellations", required = true)
        final ImmutableList<Integer> constellationIDs,
        @JsonProperty("description")
        final String description,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "region_id", required = true)
        final int id
    ) {
        this.constellationIDs = constellationIDs;
        this.description = description;
        this.name = name;
        ID = id;
    }

    @Override
    public ImmutableList<Integer> getConstellationIDs() {
        return constellationIDs;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return ID;
    }
}
