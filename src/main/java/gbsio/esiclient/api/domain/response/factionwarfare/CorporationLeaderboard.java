package gbsio.esiclient.api.domain.response.factionwarfare;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.factionwarfare.CorporationLeaderboardImpl;

/**
 * Represents a faction warfare leaderboard for corporations.
 */
@JsonDeserialize(as = CorporationLeaderboardImpl.class)
public interface CorporationLeaderboard extends Leaderboard {
}
