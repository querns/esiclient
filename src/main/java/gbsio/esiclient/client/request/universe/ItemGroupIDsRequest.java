package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Retrieves the IDs of all item groups in Eve.
 */
final public class ItemGroupIDsRequest implements GetListRequest<Integer, ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/universe/groups/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() { };
    }
}
