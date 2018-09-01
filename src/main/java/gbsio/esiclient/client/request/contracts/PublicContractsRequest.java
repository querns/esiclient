package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.Contract;
import gbsio.esiclient.api.request.specific.GetListRequest;

/**
 * Retrieves all public contracts in a region.
 */
public class PublicContractsRequest implements GetListRequest<Contract, ImmutableList<Contract>> {
    private final int regionID;

    /**
     * @param regionID the ID of the region to query
     */
    public PublicContractsRequest(final int regionID) {
        this.regionID = regionID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/contracts/public/%d/", regionID);
    }

    @Override
    public TypeReference<ImmutableList<Contract>> getExpectedType() {
        return new TypeReference<ImmutableList<Contract>>() { };
    }
}
