package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves all item category IDs.
 */
final public class ItemCategoryIDsRequest implements GetRequest<ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/universe/categories/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
