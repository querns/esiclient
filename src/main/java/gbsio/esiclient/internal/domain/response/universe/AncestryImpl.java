package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.Ancestry;

import java.util.Optional;

public class AncestryImpl implements Ancestry {
    private final int bloodlineID;
    private final String description;
    private final Integer iconID;
    private final int ID;
    private final String name;
    private final String shortDescription;

    AncestryImpl(
        @JsonProperty(value = "bloodline_id", required = true)
        final int bloodlineID,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty("icon_id")
        final Integer iconID,
        @JsonProperty(value = "id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty("short_description")
        final String shortDescription
    ) {
        this.bloodlineID = bloodlineID;
        this.description = description;
        this.iconID = iconID;
        ID = id;
        this.name = name;
        this.shortDescription = shortDescription;
    }

    @Override
    public int getBloodlineID() {
        return bloodlineID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Optional<Integer> getIconID() {
        return Optional.ofNullable(iconID);
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
    public Optional<String> getShortDescription() {
        return Optional.ofNullable(shortDescription);
    }
}
