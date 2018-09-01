package gbsio.esiclient.api.domain.response.errors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.response.impl.errors.ForbiddenErrorImpl;

/**
 * Represents extra information from a forbidden error.
 */
@JsonDeserialize(as=ForbiddenErrorImpl.class)
public interface ForbiddenError extends Error {
    /**
     * Gets the status code received from SSO.
     *
     * @return the SSO status code
     */
    int getSsoStatus();

}
