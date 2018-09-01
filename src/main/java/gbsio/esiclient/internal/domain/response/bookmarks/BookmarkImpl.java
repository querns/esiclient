package gbsio.esiclient.internal.domain.response.bookmarks;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.bookmarks.Bookmark;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkItem;
import gbsio.esiclient.api.domain.response.common.Coordinates;

import java.time.ZonedDateTime;
import java.util.Optional;

public class BookmarkImpl implements Bookmark {
    private final int id;
    private final ZonedDateTime created;
    private final String label;
    private final String notes;
    private final int locationID;
    private final int creatorID;

    private final Integer folderID;
    private final BookmarkItem item;
    private final Coordinates coordinates;

    BookmarkImpl(
        @JsonProperty(value = "bookmark_id", required = true)
        int id,
        @JsonProperty(value = "created", required = true)
        ZonedDateTime created,
        @JsonProperty(value = "label", required = true)
        String label,
        @JsonProperty(value = "notes", required = true)
        String notes,
        @JsonProperty(value = "location_id", required = true)
        int locationID,
        @JsonProperty(value = "creator_id", required = true)
        int creatorID,
        @JsonProperty(value = "folder_id")
        Integer folderID,
        @JsonProperty(value = "item")
        BookmarkItem item,
        @JsonProperty(value = "coordinates")
        Coordinates coordinates
    ) {
        this.id = id;
        this.created = created;
        this.label = label;
        this.notes = notes;
        this.locationID = locationID;
        this.creatorID = creatorID;
        this.folderID = folderID;
        this.item = item;
        this.coordinates = coordinates;
    }

    public int getID() {
        return id;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public String getLabel() {
        return label;
    }

    public String getNotes() {
        return notes;
    }

    public int getLocationID() {
        return locationID;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public Optional<Integer> getFolderID() {
        return Optional.ofNullable(folderID);
    }

    public Optional<BookmarkItem> getItem() {
        return Optional.ofNullable(item);
    }

    public Optional<gbsio.esiclient.api.domain.response.common.Coordinates> getCoordinates() {
        return Optional.ofNullable(coordinates);
    }
}
