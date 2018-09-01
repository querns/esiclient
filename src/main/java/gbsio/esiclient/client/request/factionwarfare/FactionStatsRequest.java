package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.FactionStats;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieve statistics about the factions involved in faction warfare.
 */
final public class FactionStatsRequest implements GetRequest<ImmutableList<FactionStats>> {
    @Override
    public String getURL() {
        return "/v1/fw/stats/";
    }

    @Override
    public TypeReference<ImmutableList<FactionStats>> getExpectedType() {
        return new TypeReference<ImmutableList<FactionStats>>() {
        };
    }
}
