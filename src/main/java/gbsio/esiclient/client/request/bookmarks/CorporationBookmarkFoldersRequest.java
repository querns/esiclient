package gbsio.esiclient.client.request.bookmarks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkFolder;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests information about the corporation's bookmarks.
 */
final public class CorporationBookmarkFoldersRequest implements GetListRequest<BookmarkFolder, ImmutableList<BookmarkFolder>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation whose bookmark folders are desired
     * @param accessToken an OAuth2 access token for said corporation
     */
    public CorporationBookmarkFoldersRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/bookmarks/folders/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<BookmarkFolder>> getExpectedType() {
        return new TypeReference<ImmutableList<BookmarkFolder>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
