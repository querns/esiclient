package gbsio.esiclient.internal.hooks.response;

import gbsio.esiclient.internal.http.RawContentResponse;
import org.asynchttpclient.HttpResponseHeaders;

/**
 * Represents a hook that acts upon receipt of HTTP headers.
 */
public interface HeadersHook {
    /**
     * Processes the headers from the specified part of the response's lifecycle.
     * @param headers headers from the server response
     * @param builder the response builder
     */
    void process(HttpResponseHeaders headers, RawContentResponse.Builder builder);
}
