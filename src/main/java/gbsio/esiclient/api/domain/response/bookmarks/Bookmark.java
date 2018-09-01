package gbsio.esiclient.api.domain.response.bookmarks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.internal.domain.response.bookmarks.BookmarkImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Describes a bookmark. Bookmarks are created by characters or corporations
 * to provide quick access to points or objects in space.
 */
@JsonDeserialize(as = BookmarkImpl.class)
public interface Bookmark {
    /**
     * Get the uniquely identifying ID for this bookmark.
     *
     * @return an ID
     */
    int getID();

    /**
     * Get the date and time of creation of this bookmark.
     *
     * @return a date and time
     */
    ZonedDateTime getCreated();

    /**
     * Get the user-defined label for this bookmark.
     *
     * @return a label
     */
    String getLabel();

    /**
     * Get the user-defined notes for this bookmark.
     *
     * @return the notes
     */
    String getNotes();

    /**
     * Get the location ID for this bookmark.
     *
     * This will typically be a solar system.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the location ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getLocationID();

    /**
     * Get the ID of the creator of this bookmark.
     *
     * This will typically be a character, even for corporation-scope bookmarks.
     *
     * @return the creator ID
     * @see CharacterInfo
     */
    int getCreatorID();

    /**
     * Get the ID for the folder containing this bookmark.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the folder ID
     * @see BookmarkFolder
     */
    Optional<Integer> getFolderID();

    /**
     * Get the item associated with this bookmark.
     *
     * A user can choose to bookmark an object in space rather than an arbitrary
     * location. When this is done, the bookmark will retain information about
     * the item so bookmarked.
     *
     * @return the item bookmarked.
     */
    Optional<BookmarkItem> getItem();

    /**
     * Get the coordinates of this bookmark.
     *
     * @return the coordinates
     */
    Optional<Coordinates> getCoordinates();
}
