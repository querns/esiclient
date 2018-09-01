package gbsio.esiclient.api.domain.response.bookmarks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.bookmarks.BookmarkFolderImpl;

import java.util.Optional;

/**
 * Represents a folder for bookmarks.
 */
@JsonDeserialize(as = BookmarkFolderImpl.class)
public interface BookmarkFolder {
    /**
     * Get the unique ID associated with this folder.
     *
     * @return the ID
     */
    int getFolderID();

    /**
     * Get the name of this folder.
     *
     * @return the folder name
     */
    String getName();

    /**
     * Get the creator of the bookmark.
     *
     * @return the creator's character ID
     */
    Optional<Integer> getCreatorID();
}
