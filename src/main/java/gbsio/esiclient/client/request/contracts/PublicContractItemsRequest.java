package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.DetailedContractItem;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Retrieves items included or requested in a public contract.
 */
public class PublicContractItemsRequest implements GetListRequest<DetailedContractItem, ImmutableList<DetailedContractItem>> {
    private final int contractID;

    /**
     * @param contractID the ID of the contract to query
     */
    public PublicContractItemsRequest(final int contractID) {
        this.contractID = contractID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/contracts/public/items/%d/", contractID);
    }

    @Override
    public TypeReference<ImmutableList<DetailedContractItem>> getExpectedType() {
        return new TypeReference<ImmutableList<DetailedContractItem>>() {
        };
    }
}
