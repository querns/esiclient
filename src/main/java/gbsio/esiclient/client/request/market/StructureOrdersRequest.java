package gbsio.esiclient.client.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.Order;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves market orders being hosted by a player-owned structure.
 */
final public class StructureOrdersRequest implements GetListRequest<Order, ImmutableList<Order>> {
    private final long structureID;
    private final String accessToken;

    /**
     * @param structureID the ID of the structure to query
     * @param accessToken an OAuth2 access token belonging to a character with
     *                    access to the structure's market
     */
    public StructureOrdersRequest(final long structureID, final String accessToken) {
        this.structureID = structureID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/markets/structures/%d/", structureID);
    }

    @Override
    public TypeReference<ImmutableList<Order>> getExpectedType() {
        return new TypeReference<ImmutableList<Order>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
