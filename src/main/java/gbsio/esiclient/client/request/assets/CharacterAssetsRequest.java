package gbsio.esiclient.client.request.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.Asset;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Gets a list of the player's assets.
 */
final public class CharacterAssetsRequest implements GetListRequest<Asset, ImmutableList<Asset>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character to pull
     * @param accessToken an OAuth2 access token for this character
     */
    public CharacterAssetsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/assets/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<Asset>> getExpectedType() {
        return new TypeReference<ImmutableList<Asset>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
