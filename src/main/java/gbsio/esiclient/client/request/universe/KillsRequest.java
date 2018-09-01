package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemKillData;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about ship, pod, and NPC kills occurring in solar
 * systems in Eve.
 * <p></p>
 * Only solar systems with data will be listed. Wormhole space systems are not
 * returned.
 */
final public class KillsRequest implements GetRequest<ImmutableList<SystemKillData>> {
    @Override
    public String getURL() {
        return "/v2/universe/system_kills/";
    }

    @Override
    public TypeReference<ImmutableList<SystemKillData>> getExpectedType() {
        return new TypeReference<ImmutableList<SystemKillData>>() {
        };
    }
}
