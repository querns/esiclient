package gbsio.esiclient.internal.hooks.response;

import gbsio.esiclient.internal.http.RawContentResponse;

/**
 * Represents a hook that acts upon receipt of the status of an HTTP response.
 */
public interface StatusHook {
    /**
     * Processes the statusCode from the specified part of the response's lifecycle.
     * @param statusCode the status code
     * @param builder the response builder
     */
    void process(Integer statusCode, RawContentResponse.Builder builder);
}
