package gbsio.esiclient.internal.domain.response.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.location.OnlineStatus;

import java.time.ZonedDateTime;
import java.util.Optional;

public class OnlineStatusImpl implements OnlineStatus {
    private final ZonedDateTime lastLogin;
    private final ZonedDateTime lastLogout;
    private final Integer loginCount;
    private final boolean isOnline;

    OnlineStatusImpl(
        @JsonProperty("last_login")
        final ZonedDateTime lastLogin,
        @JsonProperty("last_logout")
        final ZonedDateTime lastLogout,
        @SuppressWarnings("SpellCheckingInspection") @JsonProperty("logins")
        final Integer loginCount,
        @JsonProperty(value = "online", required = true)
        final boolean isOnline
    ) {
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
        this.loginCount = loginCount;
        this.isOnline = isOnline;
    }

    @Override
    public Optional<ZonedDateTime> getLastLogin() {
        return Optional.ofNullable(lastLogin);
    }

    @Override
    public Optional<ZonedDateTime> getLastLogout() {
        return Optional.ofNullable(lastLogout);
    }

    @Override
    public Optional<Integer> getLoginCount() {
        return Optional.ofNullable(loginCount);
    }

    @Override
    public boolean isOnline() {
        return isOnline;
    }
}
