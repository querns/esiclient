package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.Race;

public class RaceImpl implements Race {
    private final int allianceID;
    private final String description;
    private final String name;
    private final int ID;

    RaceImpl(
        @JsonProperty(value = "alliance_id", required = true)
        final int allianceID,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "race_id", required = true)
        final int id
    ) {
        this.allianceID = allianceID;
        this.description = description;
        this.name = name;
        ID = id;
    }

    @Override
    public int getAllianceID() {
        return allianceID;
    }

    @Override
    public String getDescription() {
        return description;
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
