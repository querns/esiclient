package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.fleets.CurrentFleet;
import gbsio.esiclient.api.domain.common.fleets.Role;

import java.util.Optional;

public class CurrentFleetImpl implements CurrentFleet {
    private final long ID;
    private final Role role;
    private final Long squadID;
    private final Long wingID;

    CurrentFleetImpl(
        @JsonProperty(value = "fleet_id", required = true)
        final long id,
        @JsonProperty(value = "role", required = true)
        final Role role,
        @JsonProperty(value = "squad_id", required = true)
        final Long squadID,
        @JsonProperty(value = "wing_id", required = true)
        final Long wingID
    ) {
        ID = id;
        this.role = role;
        this.squadID = squadID;
        this.wingID = wingID;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public Optional<Long> getSquadID() {
        return -1L == squadID ? Optional.empty() : Optional.of(squadID);
    }

    @Override
    public Optional<Long> getWingID() {
        return -1L == wingID ? Optional.empty() : Optional.of(wingID);
    }
}
