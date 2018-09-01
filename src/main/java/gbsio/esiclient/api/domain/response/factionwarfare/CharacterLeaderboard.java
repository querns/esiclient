package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.CharacterLeaderboardImpl;

/**
 * Represents a faction warfare leaderboard for characters.
 */
@JsonDeserialize(as = CharacterLeaderboardImpl.class)
public interface CharacterLeaderboard extends Leaderboard {
}
