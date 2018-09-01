package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests the bids on a corporation's auction contract.
 */
final public class CorporationContractBidsRequest implements GetRequest<ImmutableList<ContractBid>> {
    private final int corporationID;
    private final String accessToken;
    private final long contractID;

    /**
     * @param corporationID the ID of the corporation who owns or is assigned to
     *                      the contract
     * @param accessToken an OAuth2 access token for a director of said
     *                   corporation
     * @param contractID the ID of the contract to query
     */
    public CorporationContractBidsRequest(final int corporationID, final String accessToken, final long contractID) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.contractID = contractID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/contracts/%d/bids/", corporationID, contractID);
    }

    @Override
    public TypeReference<ImmutableList<ContractBid>> getExpectedType() {
        return new TypeReference<ImmutableList<ContractBid>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
