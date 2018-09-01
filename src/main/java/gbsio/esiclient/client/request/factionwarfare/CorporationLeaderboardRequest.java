package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.factionwarfare.CorporationLeaderboard;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about the top 10 performing corporations in faction
 * warfare.
 */
final public class CorporationLeaderboardRequest implements GetRequest<CorporationLeaderboard> {
    @Override
    public String getURL() {
        return "/v1/fw/leaderboards/corporations/";
    }

    @Override
    public TypeReference<CorporationLeaderboard> getExpectedType() {
        return new TypeReference<CorporationLeaderboard>() {
        };
    }
}
