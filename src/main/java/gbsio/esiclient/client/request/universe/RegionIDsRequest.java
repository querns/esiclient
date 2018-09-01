package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves a list of region IDs.
 */
final public class RegionIDsRequest implements GetRequest<ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/universe/regions/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
