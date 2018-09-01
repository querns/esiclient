package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Retrieves bids on a public auction contract.
 */
public class PublicContractBidsRequest implements GetListRequest<ContractBid, ImmutableList<ContractBid>> {
    private final int contractID;

    /**
     * @param contractID the ID of the contract to query
     */
    public PublicContractBidsRequest(final int contractID) {
        this.contractID = contractID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/contracts/public/bids/%d/", contractID);
    }

    @Override
    public TypeReference<ImmutableList<ContractBid>> getExpectedType() {
        return new TypeReference<ImmutableList<ContractBid>>() {
        };
    }
}
