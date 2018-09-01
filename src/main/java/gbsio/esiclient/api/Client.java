package gbsio.esiclient.api;

import java.util.concurrent.CompletableFuture;

/**
 * Sends requests to the ESI server, with optional low priority mode.
 */
public interface Client extends BaseClient {
    /**
     * Acquires a client that executes requests one at a time.
     * <p>
     * A low priority client still returns {@link CompletableFuture}
     * results, but the requests are executed one at a time. Any number of
     * requests may be queued in this manner. Requests submitted at a given time
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html#MemoryVisibility">happen-before</a>
     * requests submitted afterward.
     * <p>
     * Endpoints with paginated responses are not immune; each page is pulled
     * sequentially, with page 2 being requested before page 3, etc. The
     * {@link CompletableFuture} for a paginated request won't join until all
     * pages have been pulled.
     * <p>
     * A low priority client also abides by the global maximum parallel
     * requests. If a regular client and a low priority client are used at
     * the same time, each instance will compete for the resources available,
     * but with the low priority client only ever consuming up to one request
     * "slot."
     *
     * @return the low priority client
     */
    BaseClient withLowPriority();
}
