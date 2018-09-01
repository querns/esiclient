package gbsio.esiclient.internal.hooks.response.impl;

import com.google.inject.Singleton;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.hooks.response.HeadersHook;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.util.DateParser;
import org.asynchttpclient.HttpResponseHeaders;

@Singleton
public class ExpirationHook implements HeadersHook {
    ExpirationHook() {
    }

    @Override
    public void process(final HttpResponseHeaders headers, final RawContentResponse.Builder builder) {
        if (headers.getHeaders().contains(Constants.EXPIRY_HEADER)) {
            DateParser.parseRFC7231(
                headers.getHeaders().get(Constants.EXPIRY_HEADER)
            ).ifPresent(builder::setExpiryDate);
        }
    }
}
