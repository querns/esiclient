package gbsio.esiclient.internal.domain.response.bookmarks;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkFolder;

import java.util.Optional;

public class BookmarkFolderImpl implements BookmarkFolder {
    private final int folderID;
    private final String name;
    private final Integer creatorID;

    BookmarkFolderImpl(
        @JsonProperty(value = "folder_id", required = true)
        final int folderID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty("creator_id")
        final Integer creatorID
    ) {
        this.folderID = folderID;
        this.name = name;
        this.creatorID = creatorID;
    }

    @Override
    public int getFolderID() {
        return folderID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<Integer> getCreatorID() {
        return Optional.ofNullable(creatorID);
    }
}
