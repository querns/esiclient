package gbsio.esiclient.internal.response.impl;

import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.response.BooleanResponse;

import java.util.Optional;

class BooleanResponseImpl implements BooleanResponse {
    private final boolean successful;
    private final ErrorType errorType;
    private final Error error;
    private final boolean deprecated;

    BooleanResponseImpl(final boolean successful, final ErrorType errorType, final Error error, final boolean deprecated) {
        this.successful = successful;
        this.errorType = errorType;
        this.error = error;
        this.deprecated = deprecated;
    }

    BooleanResponseImpl(final boolean successful, final boolean deprecated) {
        this(successful, null, null, deprecated);
    }

    public boolean wasSuccessful() {
        return successful;
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
    public boolean isDeprecated() {
        return deprecated;
    }
}
