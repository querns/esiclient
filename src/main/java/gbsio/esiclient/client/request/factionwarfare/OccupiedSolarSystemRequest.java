package gbsio.esiclient.client.request.factionwarfare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.OccupiedSolarSystem;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieve information about the ownership of solar systems by factions
 * involved in faction warfare.
 */
final public class OccupiedSolarSystemRequest implements GetRequest<ImmutableList<OccupiedSolarSystem>> {
    @Override
    public String getURL() {
        return "/v2/fw/systems/";
    }

    @Override
    public TypeReference<ImmutableList<OccupiedSolarSystem>> getExpectedType() {
        return new TypeReference<ImmutableList<OccupiedSolarSystem>>() {
        };
    }
}
