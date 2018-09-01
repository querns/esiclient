package gbsio.esiclient.api.domain.response.bookmarks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.bookmarks.BookmarkItemImpl;

/**
 * Represents the item that the user bookmarked.
 */
@JsonDeserialize(as = BookmarkItemImpl.class)
public interface BookmarkItem {
    /**
     * Get the unique ID associated with this item.
     *
     * @return the ID
     */
    long getItemID();

    /**
     * Get the type ID of this item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getTypeID();
}
