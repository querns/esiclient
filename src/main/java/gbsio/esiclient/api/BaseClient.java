package gbsio.esiclient.api;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.BooleanRequest;
import gbsio.esiclient.api.request.ListRequest;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;

import java.util.concurrent.CompletableFuture;

/**
 * Sends requests to the ESI server.
 */
public interface BaseClient {
    /**
     * Sends a request to the ESI server.
     *
     * @param request a request to read from or write information to ESI
     * @param <T> the expected type of object from a successful request
     * @return a future that contains the requested object or completes
     *         exceptionally
     */
    <T> CompletableFuture<Response<T>> sendRequest(Request<T> request);

    /**
     * Sends a request to the ESI server, cascading out requests for paginated
     * endpoints.
     *
     * @param request a request to read information from ESI
     * @param <U> the expected type of objects to be pulled from ESI
     * @param <T> a list type containing objects of type U
     * @return a future that contains the requested objects from all pages or
     *         that completes exceptionally
     */
    <U, T extends ImmutableList<U>> CompletableFuture<Response<ImmutableList<U>>> sendRequest(ListRequest<U, T> request);

    /**
     * Sends a request to the ESI server.
     *
     * @param request a request expecting only success or failure
     * @return a future that contains the results of the request or that
     *         completes exceptionally
     */
    CompletableFuture<BooleanResponse> sendRequest(BooleanRequest request);
}
