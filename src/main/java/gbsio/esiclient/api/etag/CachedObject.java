package gbsio.esiclient.api.etag;

import java.util.Optional;

/**
 * Represents an object that is being cached by an {@link ETagCache}.
 */
public interface CachedObject {
    /**
     * Get the serialized object.
     *
     * @return a JSON-serialized object
     */
    String getJson();

    /**
     * Gets the total number of pages in the request, if applicable.
     *
     * @return the page count, or absent if missing
     */
    Optional<Integer> getPageCount();
}
