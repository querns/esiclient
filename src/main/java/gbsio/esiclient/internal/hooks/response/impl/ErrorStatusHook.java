package gbsio.esiclient.internal.hooks.response.impl;

import com.google.common.collect.Range;
import com.google.inject.Singleton;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.http.ResponseState;
import gbsio.esiclient.internal.hooks.response.StatusHook;

/**
 * Sets the error status of the response if the HTTP response code is in an
 * error range.
 */
@Singleton
public class ErrorStatusHook implements StatusHook {
    private static final Range<Integer> ERROR_RANGE = Range.closed(400, 599);

    ErrorStatusHook() {
    }

    @Override
    public void process(final Integer statusCode, RawContentResponse.Builder builder) {
        if (ERROR_RANGE.contains(statusCode)) {
            builder.setState(ResponseState.ERROR);
            builder.setErrorType(ErrorType.of(statusCode));
        }
    }
}
