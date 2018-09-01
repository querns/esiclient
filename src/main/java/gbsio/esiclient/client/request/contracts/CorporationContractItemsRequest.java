package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractItem;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests the items for an auction, courier, or item exchange contract
 * belonging to a corporation.
 */
final public class CorporationContractItemsRequest implements GetRequest<ImmutableList<ContractItem>> {
    private final int corporationID;
    private final String accessToken;
    private final long contractID;

    /**
     * @param corporationID the ID of the corporation that owns or is assigned
     *                     to the contract
     * @param accessToken an OAuth2 access token for a director in said
     *                    corporation
     * @param contractID the ID of the contract to query
     */
    public CorporationContractItemsRequest(final int corporationID, final String accessToken, final long contractID) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.contractID = contractID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/contracts/%d/items/", corporationID, contractID);
    }

    @Override
    public TypeReference<ImmutableList<ContractItem>> getExpectedType() {
        return new TypeReference<ImmutableList<ContractItem>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
