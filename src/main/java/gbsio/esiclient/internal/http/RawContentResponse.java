package gbsio.esiclient.internal.http;

import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.Response;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents raw data from ESI, yet to be parsed into a useful form.
 */
public interface RawContentResponse {
    /**
     * Gets the input stream for the response.
     *
     * @return the input stream
     */
    Optional<String> getResponseBody();

    /**
     * Gets the state of the response.
     *
     * @return the response state
     */
    ResponseState getState();

    /**
     * Gets the type of error, if any.
     *
     * @return the error type, or {@link ErrorType#UNKNOWN} on a non-error
     */
    ErrorType getErrorType();

    /**
     * Gets the number of pages in the response.
     *
     * @return the page count, or absent if the endpoint isn't paginated
     */
    Optional<Integer> getPageCount();

    /**
     * Returns true if the server gave a deprecation warning during this request.
     *
     * @return true if route is deprecated
     */
    default boolean isDeprecated() {
        return false;
    }

    /**
     * Gets the ETag associated with this request.
     *
     * @return the ETag, optionally
     */
    default Optional<String> getETag() {
        return Optional.empty();
    }

    /**
     * Gets the date that the data in the response becomes expired.
     *
     * @return the expiry date
     */
    Optional<ZonedDateTime> getExpiryDate();

    static RawContentResponse.Builder builder() {
        return new Builder() {
            private final Response.ResponseBuilder responseBuilder = new Response.ResponseBuilder();

            private ResponseState state = ResponseState.SUCCESS;
            private ErrorType errorType = ErrorType.UNKNOWN;
            private boolean deprecated = false;
            private String etag = null;
            private ZonedDateTime expiryDate = null;

            @Override
            public Builder setState(final ResponseState state) {
                this.state = state;
                return this;
            }

            @Override
            public Builder setErrorType(final ErrorType errorType) {
                this.errorType = errorType;
                return this;
            }

            @Override
            public Builder setDeprecated(final boolean deprecated) {
                this.deprecated = deprecated;
                return this;
            }

            public Builder setETag(final String etag) {
                this.etag = etag;
                return this;
            }

            @Override
            public Builder setExpiryDate(final ZonedDateTime expiryDate) {
                this.expiryDate = expiryDate;
                return this;
            }

            @Override
            public Builder accumulate(final HttpResponseStatus status) {
                responseBuilder.accumulate(status);
                return this;
            }

            @Override
            public Builder accumulate(final HttpResponseHeaders headers) {
                responseBuilder.accumulate(headers);
                return this;
            }

            @Override
            public Builder accumulate(final HttpResponseBodyPart bodyPart) {
                responseBuilder.accumulate(bodyPart);
                return this;
            }

            @Override
            public RawContentResponse build() {
                return new Impl(responseBuilder.build(), state, errorType, deprecated, etag, expiryDate);
            }
        };
    }

    interface Builder {
        @SuppressWarnings("UnusedReturnValue")
        Builder setState(ResponseState state);
        @SuppressWarnings("UnusedReturnValue")
        Builder setErrorType(ErrorType errorType);
        @SuppressWarnings("UnusedReturnValue")
        Builder setDeprecated(boolean deprecated);
        @SuppressWarnings("UnusedReturnValue")
        Builder setETag(String etag);
        @SuppressWarnings("UnusedReturnValue")
        Builder setExpiryDate(ZonedDateTime expiryDate);
        @SuppressWarnings("UnusedReturnValue")
        Builder accumulate(final HttpResponseStatus status);
        @SuppressWarnings("UnusedReturnValue")
        Builder accumulate(final HttpResponseHeaders headers);
        @SuppressWarnings("UnusedReturnValue")
        Builder accumulate(final HttpResponseBodyPart bodyPart);
        RawContentResponse build();
    }

    class Impl implements RawContentResponse {
        private final Response response;
        private final ResponseState state;
        private final ErrorType errorType;
        private final boolean deprecated;
        private final String etag;
        private final ZonedDateTime expiryDate;

        private Impl(@Nullable Response response, ResponseState state, ErrorType errorType, final boolean deprecated, final String etag, final ZonedDateTime expiryDate) {
            this.response = response;
            this.state = state;
            this.errorType = errorType;
            this.deprecated = deprecated;
            this.etag = etag;
            this.expiryDate = expiryDate;
        }

        @Override
        public Optional<String> getResponseBody() {
            if (null == response) {
                return Optional.empty();
            }

            return Optional.ofNullable(response.getResponseBody());
        }

        @Override
        public ResponseState getState() {
            return state;
        }

        @Override
        public ErrorType getErrorType() {
            return errorType;
        }

        @Override
        public Optional<Integer> getPageCount() {
            if (null != response && response.getHeaders().contains(Constants.PAGE_COUNT_RESPONSE_HEADER)) {
                final String pageCount = response.getHeader(Constants.PAGE_COUNT_RESPONSE_HEADER);

                if (null != pageCount) {
                    return Optional.of(Integer.valueOf(pageCount));
                }
            }
            return Optional.empty();
        }

        @Override
        public boolean isDeprecated() {
            return deprecated;
        }

        @Override
        public Optional<String> getETag() {
            return Optional.ofNullable(etag);
        }

        @Override
        public Optional<ZonedDateTime> getExpiryDate() {
            return Optional.ofNullable(expiryDate);
        }
    }
}
