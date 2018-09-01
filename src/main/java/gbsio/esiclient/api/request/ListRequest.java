package gbsio.esiclient.api.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Map;
import java.util.Optional;

/**
 * A request to ESI that aggregates multiple calls into a single list response.
 *
 * Used when the endpoint in question may be paginated. {@link Request} may
 * also return a list of items, but calling a {@link Request} WILL NOT cascade
 * into other HTTP calls.
 *
 * @param <U> the expected return type
 * @param <T> the type of the list containing the expected return type
 */
public interface ListRequest<U, T extends ImmutableList<U>> {
    /**
     * Gets the relative URL for this endpoint
     *
     * @return a relative URL
     */
    String getURL();

    /**
     * Gets parameters to be sent via a URL's query string, if any.
     *
     * @return a map of query string parameters
     */
    default Map<String, Object> getQueryParameters() {
        return ImmutableMap.of();
    }

    /**
     * Gets the authentication token.
     *
     * Used for endpoints that require authentication.
     *
     * @return an authentication token, optionally
     */
    default Optional<String> getAccessToken() {
        return Optional.empty();
    }

    /**
     * Gets the object to be used as a request body.
     *
     * Object MUST be serializable via Jackson.
     *
     * @return the request body object, optionally
     */
    default Optional<Object> getRequestBody() {
        return Optional.empty();
    }

    /**
     * Gets a reference to the expected return type for this request.
     *
     * @return the expected return type
     */
    TypeReference<T> getExpectedType();

    /**
     * Gets the HTTP method used by this request.
     *
     * @return the HTTP method
     */
    HttpMethod getHttpMethod();
}
