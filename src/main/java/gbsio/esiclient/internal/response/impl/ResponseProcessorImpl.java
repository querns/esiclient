package gbsio.esiclient.internal.response.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.request.ListRequest;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.http.ResponseState;
import gbsio.esiclient.internal.json.JsonParser;
import gbsio.esiclient.internal.response.ErrorParser;
import gbsio.esiclient.internal.response.ResponseProcessor;
import gbsio.esiclient.internal.response.impl.errors.ClientError;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class ResponseProcessorImpl implements ResponseProcessor {
    private final ErrorParser errorParser;
    private final JsonParser jsonParser;

    @Inject
    ResponseProcessorImpl(
        final ErrorParser errorParser,
        final JsonParser jsonParser
    ) {
        this.errorParser = errorParser;
        this.jsonParser = jsonParser;
    }

    @Override
    public <T> Response<T> deserializeResponse(RawContentResponse response, TypeReference<T> typeReference) {
        return getError(response, typeReference).orElseGet(() -> {
            try {
                return new ResponseImpl<>(
                    jsonParser.parse(response, typeReference),
                    response.isDeprecated(),
                    response.getExpiryDate().orElse(null));
            } catch (IOException e) {
                return new ResponseImpl<>(
                    new ClientError("Unable to parse response from server: ".concat(e.getMessage())),
                    ErrorType.CLIENT_EXCEPTION
                );
            }
        });
    }

    @Override
    public BooleanResponse deserializeResponse(final RawContentResponse response) {
        return getError(response).orElseGet(() -> new BooleanResponseImpl(true, response.isDeprecated()));
    }

    @Override
    public <U, T extends ImmutableList<U>> Response<ImmutableList<U>> deserializeAndFlatten(final List<RawContentResponse> responses, final ListRequest<U, T> request) {
        ImmutableList.Builder<U> builder = ImmutableList.builder();
        boolean deprecated = false;
        ZonedDateTime expiryDate = null;

        for (RawContentResponse rawContentResponse : responses) {
            final Optional<BooleanResponse> response = getError(rawContentResponse);
            if (response.isPresent()) {
                return generateErrorResponse(rawContentResponse);
            } else {
                try {
                    builder.addAll(jsonParser.parse(rawContentResponse, request.getExpectedType()));
                } catch (IOException e) {
                    return new ResponseImpl<>(
                        new ClientError("Unable to parse response from server: ".concat(e.getMessage())),
                        ErrorType.CLIENT_EXCEPTION
                    );
                }
                deprecated = rawContentResponse.isDeprecated();

                if (rawContentResponse.getExpiryDate().isPresent()) {
                    expiryDate = rawContentResponse.getExpiryDate().get();
                }
            }
        }

        return new ResponseImpl<>(builder.build(), deprecated, expiryDate);
    }

    private <T> Optional<Response<T>> getError(RawContentResponse response, @SuppressWarnings("unused") TypeReference<T> tr) {
        if (ResponseState.ERROR == response.getState()) {
            return Optional.of(generateErrorResponse(response));
        }

        return Optional.empty();
    }

    private Optional<BooleanResponse> getError(RawContentResponse response) {
        if (ResponseState.ERROR == response.getState()) {
            return Optional.of(new BooleanResponseImpl(
                false,
                response.getErrorType(),
                errorParser.parse(response),
                response.isDeprecated()
            ));
        }

        return Optional.empty();
    }

    private <T> Response<T> generateErrorResponse(final RawContentResponse response) {
        return new ResponseImpl<>(errorParser.parse(response), response.getErrorType());
    }
}
