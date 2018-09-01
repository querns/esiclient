package gbsio.esiclient.internal.hooks.response.impl;

import com.google.inject.Singleton;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.http.ResponseState;
import gbsio.esiclient.internal.hooks.response.StatusHook;

@Singleton
public class NotModifiedHook implements StatusHook {
    NotModifiedHook() {
    }

    @Override
    public void process(final Integer statusCode, final RawContentResponse.Builder builder) {
        if (304 == statusCode) {
            builder.setState(ResponseState.ETAG_HIT);
        }
    }
}
