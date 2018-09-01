package gbsio.esiclient.api.domain.response.errors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.response.impl.errors.GatewayTimeoutErrorImpl;

/**
 * Represents information specific to gateway timeout errors.
 */
@JsonDeserialize(as=GatewayTimeoutErrorImpl.class)
public interface GatewayTimeoutError extends Error {
    /**
     * Gets the number of seconds the request was given before timing out.
     *
     * @return a timeout value in seconds
     */
    int getTimeout();

}
