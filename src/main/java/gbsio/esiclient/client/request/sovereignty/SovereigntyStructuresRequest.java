package gbsio.esiclient.client.request.sovereignty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Structure;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about deployed sovereignty structures.
 */
final public class SovereigntyStructuresRequest implements GetRequest<ImmutableList<Structure>> {
    @Override
    public String getURL() {
        return "/v1/sovereignty/structures/";
    }

    @Override
    public TypeReference<ImmutableList<Structure>> getExpectedType() {
        return new TypeReference<ImmutableList<Structure>>() {
        };
    }
}
