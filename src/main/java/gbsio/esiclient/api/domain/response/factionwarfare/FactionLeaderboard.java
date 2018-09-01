package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.FactionLeaderboardImpl;

/**
 * Represents a faction warfare leaderboard specific to factions.
 */
@JsonDeserialize(as = FactionLeaderboardImpl.class)
public interface FactionLeaderboard extends Leaderboard {
}
