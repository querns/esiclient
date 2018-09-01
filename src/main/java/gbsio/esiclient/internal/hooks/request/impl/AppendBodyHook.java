package gbsio.esiclient.internal.hooks.request.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.hooks.request.PostQueryHook;
import gbsio.esiclient.internal.json.JsonParser;
import org.asynchttpclient.RequestBuilder;

/**
 * Adds a request body, if one is present.
 */
@Singleton
public class AppendBodyHook implements PostQueryHook {
    private final JsonParser parser;

    @Inject
    AppendBodyHook(final JsonParser parser) {
        this.parser = parser;
    }

    @Override
    public void process(final RequestBuilder builder, final Request<?> request) throws JsonProcessingException {
        if (request.getRequestBody().isPresent()) {
            builder.setHeader(Constants.CONTENT_TYPE_HEADER, Constants.CONTENT_TYPE_VALUE);
            final String bodyJson = parser.serialize(request.getRequestBody().get());
            builder.setBody(bodyJson);
        }
    }
}
