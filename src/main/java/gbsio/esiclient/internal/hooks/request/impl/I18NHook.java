package gbsio.esiclient.internal.hooks.request.impl;

import com.google.inject.Singleton;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.Request;
import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.hooks.request.QueryBuildingHook;
import org.asynchttpclient.RequestBuilder;

/**
 * Chooses the language to use for the request.
 */
@Singleton
public class I18NHook implements QueryBuildingHook {
    I18NHook() {
    }

    @Override
    public void process(final RequestBuilder builder, final Request<?> request) {
        if (request instanceof I18Nable) {
            ((I18Nable) request).getLanguage().ifPresent(
                language -> builder.addQueryParam(
                    Constants.LANGUAGE_REQUEST_HEADER,
                    language.getIdentifier()
                )
            );
        }
    }
}
