package gbsio.esiclient.internal.http.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.etag.CachedObject;
import gbsio.esiclient.api.etag.ETagCache;
import gbsio.esiclient.internal.http.ETagProcessor;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.http.ResponseState;

import java.util.Optional;

@Singleton
public class ETagProcessorImpl implements ETagProcessor {
    private final ETagCache eTagCache;

    @Inject
    ETagProcessorImpl(final ETagCache eTagCache) {
        this.eTagCache = eTagCache;
    }

    @Override
    public RawContentResponse processETags(RawContentResponse input, final String url) {
        if (ResponseState.ETAG_HIT == input.getState()) {
            final Optional<CachedObject> object = eTagCache.getCachedObject(url);

            //noinspection OptionalIsPresent
            if (object.isPresent()) {
                return new CachedContentResponse(input, object.get().getJson(), object.get().getPageCount().orElse(null));
            }

            return RawContentResponse.builder()
                .setErrorType(ErrorType.CLIENT_EXCEPTION)
                .setState(ResponseState.ERROR)
                .build();
        }

        if (ResponseState.SUCCESS == input.getState()
            && input.getResponseBody().isPresent()
            && input.getETag().isPresent()
        ) {
            eTagCache.storeObject(
                url,
                input.getETag().get(),
                new CachedObjectImpl(input.getResponseBody().get(), input.getPageCount().orElse(null))
            );
        }

        return input;
    }

    private static class CachedObjectImpl implements CachedObject {
        private final String json;
        private final Integer pageCount;

        private CachedObjectImpl(final String json, final Integer pageCount) {
            this.json = json;
            this.pageCount = pageCount;
        }

        @Override
        public String getJson() {
            return json;
        }

        @Override
        public Optional<Integer> getPageCount() {
            return Optional.ofNullable(pageCount);
        }
    }
}
