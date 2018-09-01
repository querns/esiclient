package gbsio.esiclient.client.request.sovereignty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Sovereignty;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves the current sovereignty of all solar systems, including both NPC
 * and player-conquered systems.
 */
final public class SovereigntyRequest implements GetRequest<ImmutableList<Sovereignty>> {
    @Override
    public String getURL() {
        return "/v1/sovereignty/map/";
    }

    @Override
    public TypeReference<ImmutableList<Sovereignty>> getExpectedType() {
        return new TypeReference<ImmutableList<Sovereignty>>() {
        };
    }
}
