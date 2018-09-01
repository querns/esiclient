package gbsio.esiclient.internal.domain.response.bookmarks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.bookmarks.Bookmark;
import gbsio.esiclient.api.domain.response.bookmarks.BookmarkItem;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkParseTest {
    @Test
    void parseWithCoordinates() throws IOException {
        ImmutableList<Bookmark> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/bookmarks/bookmarkWithCoordinates.json"),
            new TypeReference<ImmutableList<Bookmark>>() { }
        );

        assertEquals(1, list.size());
        Bookmark bookmark = list.get(0);

        assertFalse(bookmark.getItem().isPresent());
        assertEquals(5, bookmark.getID());
        assertEquals(ZonedDateTime.parse("2016-08-09T11:57:47Z"), bookmark.getCreated());
        assertEquals(2112625428, bookmark.getCreatorID());
        assertEquals(Optional.of(5), bookmark.getFolderID());
        assertEquals("Random location", bookmark.getLabel());
        assertEquals(30003430, bookmark.getLocationID());
        assertEquals("This is a random location in space", bookmark.getNotes());

        assertTrue(bookmark.getCoordinates().isPresent());
        Coordinates coordinates = bookmark.getCoordinates().get();
        assertEquals(-2958928814000D, coordinates.getX());
        assertEquals(-338367275823D, coordinates.getY());
        assertEquals(2114538075090D, coordinates.getZ());
    }

    @Test
    void parseWithItem() throws IOException {
        ImmutableList<Bookmark> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/bookmarks/bookmarkWithItem.json"),
            new TypeReference<ImmutableList<Bookmark>>() { }
        );

        assertEquals(1, list.size());
        Bookmark bookmark = list.get(0);

        assertFalse(bookmark.getCoordinates().isPresent());
        assertEquals(4, bookmark.getID());
        assertEquals(ZonedDateTime.parse("2016-08-09T11:57:47Z"), bookmark.getCreated());
        assertEquals(2112625428, bookmark.getCreatorID());
        assertEquals(Optional.of(5), bookmark.getFolderID());
        assertEquals("Stargate", bookmark.getLabel());
        assertEquals(30003430, bookmark.getLocationID());
        assertEquals("This is a stargate", bookmark.getNotes());

        assertTrue(bookmark.getItem().isPresent());
        BookmarkItem item = bookmark.getItem().get();
        assertEquals(50006722, item.getItemID());
        assertEquals(29633, item.getTypeID());
    }
}