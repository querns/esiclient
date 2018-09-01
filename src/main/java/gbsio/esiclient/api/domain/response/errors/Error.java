package gbsio.esiclient.api.domain.response.errors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.response.impl.errors.ErrorImpl;

/**
 * Represents an error thrown by ESI.
 */
@JsonDeserialize(as=ErrorImpl.class)
public interface Error {
    /**
     * Gets the error message thrown by ESI.
     *
     * @return the error message
     */
    String getErrorMessage();
}
