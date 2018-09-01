package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.fleets.Squad;

public class SquadImpl implements Squad {
    private final long ID;
    private final String name;

    SquadImpl(
        @JsonProperty(value = "id", required = true)
        final long id,
        @JsonProperty(value = "name", required = true)
        final String name
    ) {
        ID = id;
        this.name = name;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }
}
