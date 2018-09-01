package gbsio.esiclient.internal.http.impl;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.http.ResponseState;

import java.time.ZonedDateTime;
import java.util.Optional;

class CachedContentResponse implements RawContentResponse {
    private final RawContentResponse delegate;
    private final String cachedResponseJson;
    private final Integer pageCount;

    CachedContentResponse(final RawContentResponse delegate, final String cachedObjectJson, Integer pageCount) {
        this.delegate = Preconditions.checkNotNull(delegate);
        this.cachedResponseJson = Preconditions.checkNotNull(cachedObjectJson);
        this.pageCount = pageCount;
    }

    @Override
    public ResponseState getState() {
        return delegate.getState();
    }

    @Override
    public ErrorType getErrorType() {
        return delegate.getErrorType();
    }

    @Override
    public Optional<Integer> getPageCount() {
        return Optional.ofNullable(pageCount);
    }

    @Override
    public boolean isDeprecated() {
        return delegate.isDeprecated();
    }

    @Override
    public Optional<String> getETag() {
        return delegate.getETag();
    }

    @Override
    public Optional<ZonedDateTime> getExpiryDate() {
        return delegate.getExpiryDate();
    }

    @Override
    public Optional<String> getResponseBody() {
        return Optional.of(cachedResponseJson);
    }
}
