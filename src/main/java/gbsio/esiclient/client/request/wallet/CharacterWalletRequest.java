package gbsio.esiclient.client.request.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves a character's wallet balance.
 */
final public class CharacterWalletRequest implements GetRequest<Double> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to query
     * @param accessToken an OAuth2 access token belonging to said character
     */
    public CharacterWalletRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/wallet/", characterID);
    }

    @Override
    public TypeReference<Double> getExpectedType() {
        return new TypeReference<Double>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
