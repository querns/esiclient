package gbsio.esiclient.client.etag;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import gbsio.esiclient.api.etag.CachedObject;
import gbsio.esiclient.api.etag.ETagCache;
import org.javatuples.Pair;

import java.util.Optional;

/**
 * ETagCache that just keeps things in memory. Information is lost when the
 * program terminates.
 */
final public class InMemoryETagCache implements ETagCache {
    private final Cache<String, Pair<String, CachedObject>> cache = CacheBuilder
        .newBuilder()
        .maximumSize(10_000)
        .build();

    @Override
    public Optional<String> getETag(final String url) {
        return getPair(url).map(Pair::getValue0);
    }

    @Override
    public Optional<CachedObject> getCachedObject(final String url) {
        return getPair(url).map(Pair::getValue1);
    }

    @Override
    public void storeObject(final String url, final String etag, final CachedObject cachedObject) {
        cache.put(url, new Pair<>(etag, cachedObject));
    }

    private Optional<Pair<String, CachedObject>> getPair(final String url) {
        final Pair<String, CachedObject> pair = cache.getIfPresent(url);

        if (null != pair) {
            return Optional.of(pair);
        }

        return Optional.empty();
    }
}
