package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.IDNamePair;

public class IDNamePairImpl implements IDNamePair {
    private final int ID;
    private final String name;

    IDNamePairImpl(
        @JsonProperty("id")
        final int id,
        @JsonProperty("name")
        final String name
    ) {
        ID = id;
        this.name = name;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }
}
