package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.ContractItem;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Requests the items for an auction, courier, or item exchange contract
 * belonging to a character.
 */
final public class CharacterContractItemsRequest implements GetRequest<ImmutableList<ContractItem>> {
    private final int characterID;
    private final int contractID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character who owns or was assigned the
     *                    contract
     * @param accessToken an OAuth2 access token for said character
     * @param contractID the ID of the contract to query
     */
    public CharacterContractItemsRequest(final int characterID, final String accessToken, final int contractID) {
        this.characterID = characterID;
        this.contractID = contractID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/contracts/%d/items/", characterID, contractID);
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
