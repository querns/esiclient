package gbsio.functional.http.impl;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.config.ClientConfig;
import gbsio.esiclient.api.etag.CachedObject;
import gbsio.esiclient.api.etag.ETagCache;
import gbsio.esiclient.client.etag.InMemoryETagCache;
import gbsio.esiclient.client.request.universe.ItemTypeIDsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ETagProcessorImplTest extends FunctionalTestHarness {
    @Test
    void testETagHits() {
        final CountingCache countingCache = new CountingCache();
        Client client = getClient(
            ClientConfig.builder()
                .setUserAgent(FunctionalTestHarness.USER_AGENT)
                .setETagCache(countingCache)
                .build()
        );
        final ImmutableList<Integer> one = assertResponseExistsAndGet(client.sendRequest(new ItemTypeIDsRequest()).join());
        final ImmutableList<Integer> two = assertResponseExistsAndGet(client.sendRequest(new ItemTypeIDsRequest()).join());

        final int affixed = countingCache.affixed.get();
        final int cacheHits = countingCache.cacheHits.get();

        assertTrue(affixed > 1);
        assertTrue(cacheHits > 1);
        assertEquals(affixed, cacheHits);
        assertEquals(one, two);
    }

    private class CountingCache implements ETagCache {
        private final AtomicInteger cacheHits = new AtomicInteger(0);
        private final AtomicInteger affixed = new AtomicInteger(0);
        private final ETagCache delegate;

        private CountingCache() {
            this.delegate = new InMemoryETagCache();
        }

        /**
         * Gets the ETag for the given URL.
         * @param url the url for the request
         * @return the ETag, or absent if missing
         */
        @Override
        public Optional<String> getETag(final String url) {
            return delegate.getETag(url);
        }

        /**
         * Gets the object JSON cached for this URL.
         * @param url the URL corresponding to the object
         * @return the object, serialized as JSON, or absent if missing
         */
        @Override
        public Optional<CachedObject> getCachedObject(final String url) {
            final Optional<CachedObject> cachedObject = delegate.getCachedObject(url);

            cachedObject.ifPresent(unused -> cacheHits.incrementAndGet());
            return cachedObject;
        }

        /**
         * Stores JSON for an object in the cache.
         * @param url the URL corresponding to the object
         * @param etag the ETag for this URL
         * @param cachedObject the object, serialized as JSON
         */
        @Override
        public void storeObject(final String url, final String etag, final CachedObject cachedObject) {
            delegate.storeObject(url, etag, cachedObject);
            affixed.incrementAndGet();
        }
    }
}