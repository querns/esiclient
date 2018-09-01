package gbsio.esiclient.internal.domain.response.fleets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.fleets.FleetMember;
import gbsio.esiclient.api.domain.common.fleets.Role;

import java.time.ZonedDateTime;
import java.util.Optional;

public class FleetMemberImpl implements FleetMember {
    private final int characterID;
    private final ZonedDateTime joinDate;
    private final Role role;
    private final String roleName;
    private final int shipTypeID;
    private final int solarSystemID;
    private final Long squadID;
    private final Long stationID;
    private final boolean willTakeFleetWarp;
    private final Long wingID;

    FleetMemberImpl(
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty(value = "join_time", required = true)
        final ZonedDateTime joinDate,
        @JsonProperty(value = "role", required = true)
        final Role role,
        @JsonProperty(value = "role_name", required = true)
        final String roleName,
        @JsonProperty(value = "ship_type_id", required = true)
        final int shipTypeID,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "squad_id", required = true)
        final Long squadID,
        @JsonProperty("station_id")
        final Long stationID,
        @JsonProperty(value = "takes_fleet_warp", required = true)
        final boolean willTakeFleetWarp,
        @JsonProperty(value = "wing_id", required = true)
        final Long wingID
    ) {
        this.characterID = characterID;
        this.joinDate = joinDate;
        this.role = role;
        this.roleName = roleName;
        this.shipTypeID = shipTypeID;
        this.solarSystemID = solarSystemID;
        this.squadID = squadID;
        this.stationID = stationID;
        this.willTakeFleetWarp = willTakeFleetWarp;
        this.wingID = wingID;
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public ZonedDateTime getJoinDate() {
        return joinDate;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public int getShipTypeID() {
        return shipTypeID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public Optional<Long> getSquadID() {
        return squadID == -1 ? Optional.empty() : Optional.of(squadID);
    }

    @Override
    public Optional<Long> getStationID() {
        return Optional.ofNullable(stationID);
    }

    @Override
    public boolean willTakeFleetWarp() {
        return willTakeFleetWarp;
    }

    @Override
    public Optional<Long> getWingID() {
        return wingID == -1 ? Optional.empty() : Optional.of(wingID);
    }
}
