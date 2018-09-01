package gbsio.esiclient.internal.domain.response.clones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.clones.JumpCloneInformation;

import java.time.ZonedDateTime;
import java.util.Optional;

public class JumpCloneInformationImpl implements JumpCloneInformation {
    private final HomeLocation homeLocation;
    private final ImmutableList<Clone> jumpClones;
    private final ZonedDateTime lastCloneJumpDate;
    private final ZonedDateTime lastStationChangeDate;

    JumpCloneInformationImpl(
        @JsonProperty("home_location")
        final HomeLocation homeLocation,
        @JsonProperty("jump_clones")
        final ImmutableList<Clone> jumpClones,
        @JsonProperty("last_clone_jump_date")
        final ZonedDateTime lastCloneJumpDate,
        @JsonProperty("last_station_change_date")
        final ZonedDateTime lastStationChangeDate
    ) {
        this.homeLocation = homeLocation;
        this.jumpClones = null == jumpClones ? ImmutableList.of() : jumpClones;
        this.lastCloneJumpDate = lastCloneJumpDate;
        this.lastStationChangeDate = lastStationChangeDate;
    }

    @Override
    public Optional<HomeLocation> getHomeLocation() {
        return Optional.ofNullable(homeLocation);
    }

    @Override
    public ImmutableList<Clone> getJumpClones() {
        return jumpClones;
    }

    @Override
    public Optional<ZonedDateTime> getLastCloneJumpDate() {
        return Optional.ofNullable(lastCloneJumpDate);
    }

    @Override
    public Optional<ZonedDateTime> getLastStationChangeDate() {
        return Optional.ofNullable(lastStationChangeDate);
    }
}
