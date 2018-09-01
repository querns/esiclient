package gbsio.esiclient.internal.response;

import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.internal.http.RawContentResponse;

public interface ErrorParser {
    /**
     * Parses the response, returning an error message.
     *
     * @param response a response from ESI
     * @return an error
     */
    Error parse(RawContentResponse response);
}
