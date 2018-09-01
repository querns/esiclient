package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Title;

import java.util.Optional;

public class TitleImpl implements Title {
    private final Integer ID;
    private final String name;

    TitleImpl(
        @JsonProperty("title_id")
        final Integer id,
        @JsonProperty("name")
        final String name
    ) {
        ID = id;
        this.name = name;
    }

    public Optional<Integer> getID() {
        return Optional.ofNullable(ID);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
