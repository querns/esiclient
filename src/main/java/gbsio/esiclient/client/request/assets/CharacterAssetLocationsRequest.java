package gbsio.esiclient.client.request.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.AssetLocation;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.validation.assets.AssetIDListValidator;

import java.util.Optional;

/**
 * Gets the locations of assets for a character.
 */
final public class CharacterAssetLocationsRequest implements PostRequest<ImmutableList<AssetLocation>> {
    private final int characterID;
    private final String accessToken;
    private final ImmutableList<Long> assetIDs;

    /**
     * @param characterID the character ID for the asset locations desired
     * @param accessToken an OAuth2 access token for this character
     * @param assetIDs 1 to 1,000 item IDs of assets to query
     * @throws IllegalArgumentException if there are fewer than 1 or more than
     * 1,000 assetIDs
     */
    public CharacterAssetLocationsRequest(final int characterID, final String accessToken, final ImmutableList<Long> assetIDs) {
        AssetIDListValidator.validate(assetIDs);
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.assetIDs = assetIDs;
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/assets/locations/", characterID);
    }

    @Override
    public Optional<Object> getRequestBody() {
        return Optional.of(assetIDs);
    }

    @Override
    public TypeReference<ImmutableList<AssetLocation>> getExpectedType() {
        return new TypeReference<ImmutableList<AssetLocation>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
