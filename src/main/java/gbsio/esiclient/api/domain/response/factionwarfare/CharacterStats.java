package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.CharacterStatsImpl;

import java.util.Optional;

/**
 * Represents statistics about a character's enrollment in Faction Warfare.
 */
@JsonDeserialize(as = CharacterStatsImpl.class)
public interface CharacterStats extends ConcernStats {
    /**
     * Gets the current rank the character is at in faction warfare.
     *
     * Rank is a proxy for the character's standings with their faction.
     *
     * @return a rank between 0 and 9, or absent if the character is not
     * enrolled in faction warfare
     */
    Optional<Integer> getCurrentRank();

    /**
     * Gets the highest all-time rank the character has achieved in faction
     * warfare.
     *
     * Rank is a proxy for the character's standings with their faction.
     *
     * @return a rank between 0 and 9, or absent if the character is not
     * enrolled in faction warfare
     */
    Optional<Integer> getHighestRank();
}
