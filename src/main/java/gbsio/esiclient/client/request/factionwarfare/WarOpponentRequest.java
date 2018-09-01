package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.WarOpponent;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieve information about the wars occurring as a part of faction warfare.
 */
final public class WarOpponentRequest implements GetRequest<ImmutableList<WarOpponent>> {
    @Override
    public String getURL() {
        return "/v1/fw/wars/";
    }

    @Override
    public TypeReference<ImmutableList<WarOpponent>> getExpectedType() {
        return new TypeReference<ImmutableList<WarOpponent>>() {
        };
    }
}
