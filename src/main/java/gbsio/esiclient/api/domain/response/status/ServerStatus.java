package gbsio.esiclient.api.domain.response.status;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.status.ServerStatusImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents the status of the Eve Online servers.
 */
@JsonDeserialize(as = ServerStatusImpl.class)
public interface ServerStatus {
    /**
     * Gets the online player count.
     *
     * @return the player count
     */
    int getPlayerCount();

    /**
     * Gets the server version.
     *
     * @return the server version
     */
    String getServerVersion();

    /**
     * Gets the time the server started accepting connections.
     *
     * @return the start time
     */
    ZonedDateTime getStartDate();

    /**
     * Gets whether or not the server is only accepting connections from "VIP"
     * accounts.
     *
     * @return true if the server will only accept VIPs
     */
    Optional<Boolean> getVIPStatus();
}
