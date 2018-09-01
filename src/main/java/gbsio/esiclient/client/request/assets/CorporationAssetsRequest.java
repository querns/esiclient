package gbsio.esiclient.client.request.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.assets.Asset;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Gets the assets of a corporation.
 */
final public class CorporationAssetsRequest implements GetListRequest<Asset, ImmutableList<Asset>> {
    private final int corporationID;
    private final String accessToken;

    public CorporationAssetsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v3/corporations/%d/assets/", corporationID);
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
