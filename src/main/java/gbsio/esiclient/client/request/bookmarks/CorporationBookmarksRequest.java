package gbsio.esiclient.client.request.bookmarks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.Bookmark;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests the corporation's bookmarks.
 */
final public class CorporationBookmarksRequest implements GetListRequest<Bookmark, ImmutableList<Bookmark>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation whose bookmarks are desired
     * @param accessToken an OAuth2 access token for said corporation
     */
    public CorporationBookmarksRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/bookmarks/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<Bookmark>> getExpectedType() {
        return new TypeReference<ImmutableList<Bookmark>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
