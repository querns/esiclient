package gbsio.esiclient.client.request.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Gets a list of IDs of opportunity groups.
 */
final public class OpportunityGroupIDsRequest implements GetRequest<ImmutableList<Integer>> {
    @Override
    public String getURL() {
        return "/v1/opportunities/groups/";
    }

    @Override
    public TypeReference<ImmutableList<Integer>> getExpectedType() {
        return new TypeReference<ImmutableList<Integer>>() {
        };
    }
}
