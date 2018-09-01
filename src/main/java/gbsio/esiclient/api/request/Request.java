package gbsio.esiclient.api.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Map;
import java.util.Optional;

/**
 * Represents a request to ESI that returns information on success.
 *
 * Different from {@link ListRequest} in that a Request will not detect and
 * automatically generate paginated requests.
 *
 * @param <T> the expected return type
 */
public interface Request<T> {
    /**
     * Gets the HTTP method used by this request.
     *
     * @return the HTTP method
     */
    HttpMethod getHttpMethod();

    /**
     * Gets the relative URL for this endpoint
     *
     * @return a relative URL
     */
    String getURL();

    /**
     * Gets the object to be used as a request body.
     *
     * Object MUST be serializable via Jackson.
     *
     * @return the request body object, optionally
     */
    Optional<Object> getRequestBody();

    /**
     * Gets a reference to the expected return type for this request.
     *
     * @return the expected return type
     */
    TypeReference<T> getExpectedType();

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
}
