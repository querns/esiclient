package gbsio.esiclient.internal.response.impl;

import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.response.Response;

import java.time.ZonedDateTime;
import java.util.Optional;

class ResponseImpl<T> implements Response<T> {
    private final ErrorType errorType;
    private final Error error;
    private final T responseObject;
    private final boolean deprecated;
    private final ZonedDateTime expiryDate;

    ResponseImpl(T responseObject, boolean deprecated, final ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
        errorType = null;
        error = null;
        this.responseObject = responseObject;
        this.deprecated = deprecated;
    }

    ResponseImpl(Error error, ErrorType errorType) {
        this.errorType = errorType;
        this.error = error;
        this.expiryDate = null;
        responseObject = null;
        this.deprecated = false;
    }

    @Override
    public Optional<ErrorType> getErrorType() {
        return Optional.ofNullable(errorType);
    }

    @Override
    public Optional<Error> getError() {
        return Optional.ofNullable(error);
    }

    @Override
    public Optional<T> getResponseObject() {
        return Optional.ofNullable(responseObject);
    }

    @Override
    public boolean isDeprecated() {
        return deprecated;
    }

    @Override
    public Optional<ZonedDateTime> getExpiryDate() {
        return Optional.ofNullable(expiryDate);
    }
}
