package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.character.FatigueInformationImpl;

import java.time.*;
import java.util.Optional;

/**
 * Contains information about the character's current accumulation of jump
 * fatigue.
 *
 * @see <a href="https://support.eveonline.com/hc/en-us/articles/212726865-Jump-Activation-Cooldown-and-Jump-Fatigue">https://support.eveonline.com/hc/en-us/articles/212726865-Jump-Activation-Cooldown-and-Jump-Fatigue</a>
 */
@JsonDeserialize(as = FatigueInformationImpl.class)
public interface FatigueInformation {
    /**
     * Get the date and time at which the character's jump fatigue expires.
     *
     * @return the date and time at which the character's jump fatigue expires
     */
    Optional<ZonedDateTime> getExpiry();

    /**
     * Get the date and time of the character's last capital jump.
     *
     * @return the date and time of the character's last capital jump
     */
    Optional<ZonedDateTime> getLastJump();

    /**
     * Get the character's last jump update time and date
     *
     * @return the character's last jump update
     */
    Optional<ZonedDateTime> getLastUpdate();

    /**
     * Determine if the character is currently suffering enough jump fatigue to
     * impede further jumps.
     *
     * This is defined as having more than ten minutes of fatigue.
     *
     * @return true if the character has a meaningful amount of jump fatigue
     */
    default boolean isFatigued() {
        LocalDate expiry, now;

        if (getExpiry().isPresent()) {
            expiry = getExpiry().get().toLocalDate();
            now = LocalDate.now();

            if (expiry.isAfter(now)) {
                return Duration.between(now, expiry).toMinutes() > 10;
            }
        }

        return false;
    }
}
