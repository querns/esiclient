package gbsio.esiclient.api.request;

import com.google.common.collect.ImmutableMap;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Map;
import java.util.Optional;

/**
 * A request to ESI that has a simple success or failure state.
 */
public interface BooleanRequest {
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
     * Gets the HTTP method used by this request.
     *
     * @return the HTTP method
     */
    HttpMethod getHttpMethod();
}
