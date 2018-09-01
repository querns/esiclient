package gbsio.esiclient.internal.hooks.response.impl;

import com.google.inject.Singleton;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.hooks.response.HeadersHook;
import org.asynchttpclient.HttpResponseHeaders;

@Singleton
public class NewETagHook implements HeadersHook {
    NewETagHook() {
    }

    @Override
    public void process(final HttpResponseHeaders headers, final RawContentResponse.Builder builder) {
        if (headers.getHeaders().contains(Constants.ETAG_HEADER)) {
            builder.setETag(headers.getHeaders().get(Constants.ETAG_HEADER));
        }
    }
}
