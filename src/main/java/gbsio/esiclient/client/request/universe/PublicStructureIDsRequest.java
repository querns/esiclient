package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Map;
import java.util.Optional;

/**
 * Retrieves a list of IDs of public player-owned structures.
 */
final public class PublicStructureIDsRequest implements GetRequest<ImmutableList<Long>> {

    private final String filter;

    /**
     * @param filter Only list public structures that have this service online
     *               possible values: "market" and "manufacturing_basic"
     */
    public PublicStructureIDsRequest(String filter) {
        this.filter = filter;
    }

    public PublicStructureIDsRequest() {
        this(null);
    }

    @Override
    public String getURL() {
        return "/v1/universe/structures/";
    }

    @Override
    public Map<String, Object> getQueryParameters() {
        if (filter != null) {
            return ImmutableMap.of("filter", filter);
        } else {
            return  ImmutableMap.of();
        }
    }

    @Override
    public TypeReference<ImmutableList<Long>> getExpectedType() {
        return new TypeReference<ImmutableList<Long>>() {
        } ;
    }
}
