package gbsio.esiclient.api.domain.response.skills;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.Attributes;
import gbsio.esiclient.internal.domain.response.skills.CharacterAttributesImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents information about a character's skill training attributes and
 * attribute remap schedule.
 */
@JsonDeserialize(as = CharacterAttributesImpl.class)
public interface CharacterAttributes extends Attributes {
    /**
     * Gets the date that a character's naturally accruing remap is available.
     *
     * @return the remap cooldown date
     */
    Optional<ZonedDateTime> getRemapCooldownDate();

    /**
     * Gets the number of bonus remaps the character has accrued.
     *
     * @return the bonus remap count
     */
    Optional<Integer> getBonusRemaps();

    /**
     * Gets the last time the character used a remap.
     *
     * @return the last remap date
     */
    Optional<ZonedDateTime> getLastRemapDate();

}
