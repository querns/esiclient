package gbsio.esiclient.client.request.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contracts.OwnedContract;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests contracts created by, accepted by, or assigned to this character.
 */
final public class CharacterContractsRequest implements GetListRequest<OwnedContract, ImmutableList<OwnedContract>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of a character to query
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterContractsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/contracts/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<OwnedContract>> getExpectedType() {
        return new TypeReference<ImmutableList<OwnedContract>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
