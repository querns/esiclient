package gbsio.esiclient.internal.http;

import gbsio.esiclient.api.request.Request;

import java.util.concurrent.CompletableFuture;

/**
 * Executes HTTP requests.
 */
public interface Dispatch {
    /**
     * Accepts a request, and outputs a raw response.
     *
     * @param request the request to make to ESI
     * @return a CompletableFuture that either returns a raw response or returns
     *         exceptionally
     */
    CompletableFuture<RawContentResponse> executeSingleRequest(Request<?> request);
}
