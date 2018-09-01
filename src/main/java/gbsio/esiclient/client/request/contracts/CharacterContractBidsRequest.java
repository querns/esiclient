package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests the bids on a character's auction contract.
 */
final public class CharacterContractBidsRequest implements GetRequest<ImmutableList<ContractBid>> {
    private final int characterID;
    private final String accessToken;
    private final int contractID;

    /**
     * @param characterID the ID of the character who owns or is assigned the
     *                   contract
     * @param accessToken an OAuth2 access token for said character
     * @param contractID the ID of the contract to query
     */
    public CharacterContractBidsRequest(final int characterID, final String accessToken, final int contractID) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.contractID = contractID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/contracts/%d/bids/", characterID, contractID);
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
