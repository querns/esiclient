package gbsio.esiclient.client.etag;

import gbsio.esiclient.api.etag.CachedObject;
import gbsio.esiclient.api.etag.ETagCache;

import java.util.Optional;

/**
 * A persistence that does nothing and always returns a miss.
 */
final public class NullETagCache implements ETagCache {

    @Override
    public Optional<String> getETag(final String url) {
        return Optional.empty();
    }

    @Override
    public Optional<CachedObject> getCachedObject(final String url) {
        return Optional.empty();
    }

    @Override
    public void storeObject(final String url, final String etag, final CachedObject cachedObject) { }

}
