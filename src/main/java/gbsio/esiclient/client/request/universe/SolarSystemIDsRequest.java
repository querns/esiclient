package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves a list of IDs of solar systems.
 */
final public class SolarSystemIDsRequest implements GetRequest<ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/universe/systems/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
