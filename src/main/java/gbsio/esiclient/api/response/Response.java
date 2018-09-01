package gbsio.esiclient.api.response;

import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.api.domain.response.errors.ErrorType;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a response or error from the client.
 *
 * @param <T> the type of response that would come on a successful request
 */
public interface Response<T> {
    /**
     * Gets the response object of type {@link T}.
     *
     * @return the response object
     */
    Optional<T> getResponseObject();

    /**
     * Gets when this response expires.
     *
     * Only returned on a successful request.
     *
     * @return the expiry date, or absent if missing or not applicable.
     */
    default Optional<ZonedDateTime> getExpiryDate() {
        return Optional.empty();
    }

    /**
     * Returns true if the server has marked the endpoint used by the request as
     * deprecated.
     *
     * @return true if the endpoint is deprecated
     */
    default boolean isDeprecated() {
        return false;
    }

    /**
     * Gets the type of error associated with the response, if any
     *
     * @return the error, if any
     */
    Optional<ErrorType> getErrorType();

    /**
     * Gets the error object.
     *
     * @return the error, optionally
     */
    Optional<Error> getError();
}
