package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves a list of IDs of public player-owned structures.
 */
final public class PublicStructureIDsRequest implements GetRequest<ImmutableList<Long>> {
    @Override
    public String getURL() {
        return "/v1/universe/structures/";
    }

    @Override
    public TypeReference<ImmutableList<Long>> getExpectedType() {
        return new TypeReference<ImmutableList<Long>>() {
        } ;
    }
}
