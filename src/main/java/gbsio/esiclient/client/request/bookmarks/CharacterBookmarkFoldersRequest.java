package gbsio.esiclient.client.request.bookmarks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkFolder;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests information about the character's bookmark folders.
 */
final public class CharacterBookmarkFoldersRequest implements GetListRequest<BookmarkFolder, ImmutableList<BookmarkFolder>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character whose bookmark folders are desired
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterBookmarkFoldersRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/bookmarks/folders/", characterID);
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
