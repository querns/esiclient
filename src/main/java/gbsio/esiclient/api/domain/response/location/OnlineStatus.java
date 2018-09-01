package gbsio.esiclient.api.domain.response.location;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.location.OnlineStatusImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents information about a character's online status.
 */
@JsonDeserialize(as = OnlineStatusImpl.class)
public interface OnlineStatus {
    /**
     * Get the last time the character logged in.
     *
     * @return the last login date
     */
    Optional<ZonedDateTime> getLastLogin();

    /**
     * Get the last time the character logged out.
     *
     * @return the last logout date
     */
    Optional<ZonedDateTime> getLastLogout();

    /**
     * Get how many total times the character has logged in.
     *
     * @return the login count
     */
    Optional<Integer> getLoginCount();

    /**
     * Get whether the character is online at the time of this API call.
     *
     * @return true if the character is online
     */
    boolean isOnline();

}
