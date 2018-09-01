package gbsio.esiclient.client.request.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.AssetName;
import gbsio.esiclient.api.request.specific.PostRequest;
import gbsio.esiclient.client.validation.assets.AssetIDListValidator;

import java.util.Optional;

/**
 * Creates a request for the names of corporate-owned assets.
 */
final public class CorporationAssetNamesRequest implements PostRequest<ImmutableList<AssetName>> {
    private final int corporationID;
    private final String accessToken;
    private final ImmutableList<Long> assetIDs;

    /**
     * @param corporationID the ID of the corporation whose asset names are desired
     * @param accessToken an OAuth2 access token for said corporation
     * @param assetIDs 1 to 1,000 item IDs to query
     * @throws IllegalArgumentException if there are fewer than 1 or more than
     * 1,000 assetIDs
     */
    public CorporationAssetNamesRequest(final int corporationID, final String accessToken, final ImmutableList<Long> assetIDs) {
        AssetIDListValidator.validate(assetIDs);
        this.corporationID = corporationID;
        this.assetIDs = assetIDs;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/assets/names/", corporationID);
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
