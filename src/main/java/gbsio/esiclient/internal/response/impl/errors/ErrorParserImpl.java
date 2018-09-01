package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.api.domain.response.errors.ForbiddenError;
import gbsio.esiclient.api.domain.response.errors.GatewayTimeoutError;
import gbsio.esiclient.internal.http.RawContentResponse;
import gbsio.esiclient.internal.response.ErrorParser;

import java.io.IOException;

/**
 * Parses an error from a raw response.
 */
@Singleton
public class ErrorParserImpl implements ErrorParser {
    private final ObjectMapper objectMapper;

    @Inject
    ErrorParserImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Error parse(RawContentResponse response) {
        if (response.getResponseBody().isPresent()) {
            final String responseBody = response.getResponseBody().get();

            try {
                final TypeReference typeReference;

                switch (response.getErrorType()) {
                    case FORBIDDEN:
                        typeReference = new TypeReference<ForbiddenError>() {
                        };
                        break;
                    case GATEWAY_TIMEOUT:
                        typeReference = new TypeReference<GatewayTimeoutError>() {
                        };
                        break;
                    default:
                        typeReference = new TypeReference<Error>() {
                        };
                        break;
                }

                return objectMapper.readValue(responseBody, typeReference);
            } catch (JsonParseException e) {
                return new ClientError("Unable to parse error message JSON: ".concat(responseBody));
            } catch (JsonMappingException e) {
                return new ClientError("Unable to map well-formed JSON to an error object");
            } catch (IOException e) {
                return new ClientError("Low level I/O error received when parsing an error message.");
            }
        }

        return new ClientError("Response stream was missing when attempting to parse an error from ESI. ");
    }
}
