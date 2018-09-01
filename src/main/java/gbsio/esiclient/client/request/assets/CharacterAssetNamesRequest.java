package gbsio.esiclient.client.request.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.AssetName;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.validation.assets.AssetIDListValidator;

import java.util.Optional;

/**
 * Creates a request for the names of player-owned assets.
 */
final public class CharacterAssetNamesRequest implements PostRequest<ImmutableList<AssetName>> {
    private final int characterID;
    private final String accessToken;
    private final ImmutableList<Long> assetIDs;

    /**
     * @param characterID the character ID for the asset names desired
     * @param accessToken an OAuth2 access token for this character
     * @param assetIDs 1 to 1,000 item IDs to query
     * @throws IllegalArgumentException if there are fewer than 1 or more than
     * 1,000 assetIDs
     */
    public CharacterAssetNamesRequest(final int characterID, final String accessToken, final ImmutableList<Long> assetIDs) {
        AssetIDListValidator.validate(assetIDs);
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.assetIDs = assetIDs;
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/assets/names/", characterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(assetIDs);
    }

    @Override
    public TypeReference<ImmutableList<AssetName>> getExpectedType() {
        return new TypeReference<ImmutableList<AssetName>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
