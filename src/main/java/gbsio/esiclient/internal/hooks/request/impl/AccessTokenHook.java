package gbsio.esiclient.internal.hooks.request.impl;

import com.google.inject.Singleton;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.hooks.request.PostQueryHook;
import org.asynchttpclient.RequestBuilder;

/**
 * Adds the access token to the request, if present.
 */
@Singleton
public class AccessTokenHook implements PostQueryHook {
    AccessTokenHook() {
    }

    @Override
    public void process(final RequestBuilder builder, final Request<?> request) {
        request.getAccessToken().ifPresent(token -> builder.addHeader(
            Constants.AUTHORIZATION_HEADER,
            Constants.AUTHORIZATION_VALUE.concat(token)
        ));
    }
}
