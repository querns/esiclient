package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.factionwarfare.CharacterLeaderboard;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about the top 100 performing characters in faction
 * warfare.
 */
final public class CharacterLeaderboardRequest implements GetRequest<CharacterLeaderboard> {
    @Override
    public String getURL() {
        return "/v1/fw/leaderboards/characters/";
    }

    @Override
    public TypeReference<CharacterLeaderboard> getExpectedType() {
        return new TypeReference<CharacterLeaderboard>() {
        };
    }
}
