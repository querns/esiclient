package gbsio.esiclient.internal.hooks.request.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.api.etag.ETagCache;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.hooks.request.PostQueryHook;
import org.asynchttpclient.RequestBuilder;

import java.util.Optional;

/**
 * Adds an ETag to the request.
 */
@Singleton
public class AppendETagHook implements PostQueryHook {
    private final ETagCache eTagCache;

    @Inject
    AppendETagHook(final ETagCache eTagCache) {
        this.eTagCache = eTagCache;
    }

    @Override
    public void process(RequestBuilder builder, final Request<?> request) {
        final org.asynchttpclient.Request asyncRequest = builder.build();
        final Optional<String> etag = eTagCache.getETag(asyncRequest.getUrl());

        etag.ifPresent(etagValue -> builder.addHeader(
            Constants.ETAG_REQUEST_HEADER,
            etagValue
        ));
    }
}
