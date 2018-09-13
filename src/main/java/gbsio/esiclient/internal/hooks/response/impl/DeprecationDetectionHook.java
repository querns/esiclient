package gbsio.esiclient.internal.hooks.response.impl;

import com.google.inject.Singleton;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.hooks.response.HeadersHook;
import org.asynchttpclient.HttpResponseHeaders;

/**
 * Sets the deprecated flag on the response object if the server's response
 * indicated a deprecated endpoint.
 */
@Singleton
public class DeprecationDetectionHook implements HeadersHook {
    DeprecationDetectionHook() {
    }

    @Override
    public void process(final HttpResponseHeaders headers, RawContentResponse.Builder builder) {
        if (headers.getHeaders().contains("warning") && headers.getHeaders().getAll("warning").stream().anyMatch(s -> s.startsWith("299"))) {
            builder.setDeprecated(true);
        }
    }
}
