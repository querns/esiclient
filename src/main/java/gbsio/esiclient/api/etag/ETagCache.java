package gbsio.esiclient.api.etag;

import java.util.Optional;

/**
 * Interface for implementing a persistence layer for ETags and for caching
 * server responses. Implementations MUST BE THREAD SAFE!
 */
public interface ETagCache {
    /**
     * Gets the ETag for the given URL.
     * @param url the url for the request
     * @return the ETag, or absent if missing
     */
    Optional<String> getETag(String url);

    /**
     * Gets the object JSON cached for this URL.
     * @param url the URL corresponding to the object
     * @return the object, serialized as JSON, or absent if missing
     */
    Optional<CachedObject> getCachedObject(String url);

    /**
     * Stores JSON for an object in the cache.
     * @param url the URL corresponding to the object
     * @param etag the ETag for this URL
     * @param cachedObject the object, serialized as JSON
     */
    void storeObject(String url, final String etag, CachedObject cachedObject);

}
