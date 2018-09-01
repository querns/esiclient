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
        if (headers.getHeaders().contains("warning") && headers.getHeaders().get("warning").equals("299 - This route is deprecated.")) {
            builder.setDeprecated(true);
        }
    }
}
