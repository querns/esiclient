package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Gets a list of item type IDs in Eve.
 */
final public class ItemTypeIDsRequest implements GetListRequest<Integer, ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/universe/types/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }

}
