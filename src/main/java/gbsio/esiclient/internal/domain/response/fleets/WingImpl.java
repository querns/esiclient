package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.fleets.Squad;
import gbsio.esiclient.api.domain.response.fleets.Wing;

public class WingImpl implements Wing {
    private final long ID;
    private final String name;
    private final ImmutableList<Squad> squads;

    WingImpl(
        @JsonProperty(value = "id", required = true)
        final long id,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "squads", required = true)
        final ImmutableList<Squad> squads
    ) {
        ID = id;
        this.name = name;
        this.squads = MoreObjects.firstNonNull(squads, ImmutableList.of());
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ImmutableList<Squad> getSquads() {
        return squads;
    }
}
