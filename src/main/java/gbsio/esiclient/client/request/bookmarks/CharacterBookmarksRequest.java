package gbsio.esiclient.client.request.bookmarks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.Bookmark;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Requests the character's bookmarks.
 */
final public class CharacterBookmarksRequest implements GetListRequest<Bookmark, ImmutableList<Bookmark>> {
    private final int characterID;
    private final String accessToken;

    /**
     * @param characterID the ID of the character whose bookmarks are desired
     * @param accessToken an OAuth2 access token for said character
     */
    public CharacterBookmarksRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/bookmarks/", characterID);
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
