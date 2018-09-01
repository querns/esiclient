package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionLeaderboard;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about the performance of each faction in faction
 * warfare.
 */
final public class FactionLeaderboardRequest implements GetRequest<FactionLeaderboard> {
    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return "/v1/fw/leaderboards/";
    }

    @Override
    public TypeReference<FactionLeaderboard> getExpectedType() {
        return new TypeReference<FactionLeaderboard>() {
        };
    }
}
