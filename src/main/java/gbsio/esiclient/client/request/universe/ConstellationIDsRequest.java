package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves the IDs of all constellations in Eve.
 */
final public class ConstellationIDsRequest implements GetRequest<ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/universe/constellations/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
