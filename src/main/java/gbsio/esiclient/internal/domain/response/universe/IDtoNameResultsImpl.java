package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.IDtoNameResults;

public class IDtoNameResultsImpl implements IDtoNameResults {
    private final Category category;
    private final int ID;
    private final String name;

    IDtoNameResultsImpl(
        @JsonProperty(value = "category", required = true)
        final Category category,
        @JsonProperty(value = "id", required = true)
        final int id,
        @JsonProperty(value = "name", required = true)
        final String name
    ) {
        this.category = category;
        ID = id;
        this.name = name;
    }

    @Override
    public Category getCategory() {
        return category;
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
