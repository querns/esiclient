package gbsio.esiclient.internal.domain.response.bookmarks;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkItem;

public class BookmarkItemImpl implements BookmarkItem {
    private final long itemID;
    private final int typeID;

    BookmarkItemImpl(
        @JsonProperty(value = "item_id", required = true)
        long itemID,
        @JsonProperty(value = "type_id", required = true)
        int typeID
    ) {
        this.itemID = itemID;
        this.typeID = typeID;
    }

    public long getItemID() {
        return itemID;
    }

    public int getTypeID() {
        return typeID;
    }
}
