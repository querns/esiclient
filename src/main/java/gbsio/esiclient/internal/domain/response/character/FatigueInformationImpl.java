package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.FatigueInformation;

import java.time.ZonedDateTime;
import java.util.Optional;

public class FatigueInformationImpl implements FatigueInformation {
    private final ZonedDateTime expiry;
    private final ZonedDateTime lastJump;
    private final ZonedDateTime lastUpdate;

    FatigueInformationImpl(
        @JsonProperty("jump_fatigue_expire_date")
        final ZonedDateTime expiry,
        @JsonProperty("last_jump_date")
        final ZonedDateTime lastJump,
        @JsonProperty("last_update_date")
        final ZonedDateTime lastUpdate
    ) {
        this.expiry = expiry;
        this.lastJump = lastJump;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public Optional<ZonedDateTime> getExpiry() {
        return Optional.ofNullable(expiry);
    }

    @Override
    public Optional<ZonedDateTime> getLastJump() {
        return Optional.ofNullable(lastJump);
    }

    @Override
    public Optional<ZonedDateTime> getLastUpdate() {
        return Optional.ofNullable(lastUpdate);
    }
}
