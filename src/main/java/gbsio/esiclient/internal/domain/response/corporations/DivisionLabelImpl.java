package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.Divisions;

import java.util.Optional;

public class DivisionLabelImpl implements Divisions.DivisionLabel {
    private final Integer division;
    private final String name;

    DivisionLabelImpl(
        @JsonProperty("division")
        final Integer division,
        @JsonProperty("name")
        final String name
    ) {
        this.division = division;
        this.name = name;
    }

    @Override
    public Optional<Integer> getDivision() {
        return Optional.ofNullable(division);
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
