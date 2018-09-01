package gbsio.esiclient.internal.domain.response.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.status.ServerStatus;

import java.time.ZonedDateTime;
import java.util.Optional;

public class ServerStatusImpl implements ServerStatus {
    private final int players;
    private final String serverVersion;
    private final ZonedDateTime startDate;
    private final Boolean vipStatus;

    ServerStatusImpl(
        @JsonProperty(value = "players", required = true)
        final int players,
        @JsonProperty(value = "server_version", required = true)
        final String serverVersion,
        @JsonProperty(value = "start_time", required = true)
        final ZonedDateTime startDate,
        @JsonProperty("vip")
        final Boolean vipStatus
    ) {
        this.players = players;
        this.serverVersion = serverVersion;
        this.startDate = startDate;
        this.vipStatus = vipStatus;
    }

    @Override
    public int getPlayerCount() {
        return players;
    }

    @Override
    public String getServerVersion() {
        return serverVersion;
    }

    @Override
    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public Optional<Boolean> getVIPStatus() {
        return Optional.ofNullable(vipStatus);
    }
}
