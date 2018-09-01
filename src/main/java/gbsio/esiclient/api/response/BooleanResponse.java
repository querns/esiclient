package gbsio.esiclient.api.response;

import gbsio.esiclient.api.domain.response.errors.ErrorType;

import java.util.Optional;

/**
 * Represents the success or failure of a request.
 *
 * Failures will contain error information.
 */
public interface BooleanResponse {
    /**
     * Returns true if the request was successful.
     *
     * @return true on success
     */
    boolean wasSuccessful();

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
    Optional<gbsio.esiclient.api.domain.response.errors.Error> getError();
}
