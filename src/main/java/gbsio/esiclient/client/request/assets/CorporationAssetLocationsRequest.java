package gbsio.esiclient.client.request.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.AssetLocation;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.validation.assets.AssetIDListValidator;

import java.util.Optional;

/**
 * Gets the location of a corporation's assets.
 */
final public class CorporationAssetLocationsRequest implements PostRequest<ImmutableList<AssetLocation>> {
    private final int corporationID;
    private final String accessToken;
    private final ImmutableList<Long> assetIDs;

    /**
     * @param corporationID the ID of the corporation whose asset locations are desired
     * @param accessToken an OAuth2 access token for this corporation
     * @param assetIDs 1 to 1,000 item IDs to query
     * @throws IllegalArgumentException if there are fewer than 1 or more than
     * 1,000 assetIDs
     */
    public CorporationAssetLocationsRequest(final int corporationID, final String accessToken, final ImmutableList<Long> assetIDs) {
        AssetIDListValidator.validate(assetIDs);
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
        this.assetIDs = assetIDs;
    }

    @Override
    public String getURL() {
        return String.format("/v2/corporations/%d/assets/locations/", corporationID);
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
