package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.api.domain.response.errors.ErrorType;
import gbsio.esiclient.api.domain.response.errors.ForbiddenError;
import gbsio.esiclient.api.domain.response.errors.GatewayTimeoutError;
import gbsio.esiclient.internal.http.RawContentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ErrorParserImplTest {
    private ErrorParserImpl sut;
    @Mock private ObjectMapper objectMapper;
    @Mock private RawContentResponse rawContentResponse;
    private String responseBody = "body";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new ErrorParserImpl(objectMapper);
        when(rawContentResponse.getResponseBody()).thenReturn(Optional.of(responseBody));
    }

    @Test
    void parseGenerateForbiddenError() throws IOException, ClassNotFoundException {
        checkResponseType(ErrorType.FORBIDDEN, ForbiddenError.class);
    }

    @Test
    void parseGenerateGatewayTimeoutError() throws IOException, ClassNotFoundException {
        checkResponseType(ErrorType.GATEWAY_TIMEOUT, GatewayTimeoutError.class);
    }

    @Test
    void parseGenerateGenericErrors() throws IOException, ClassNotFoundException {
        int i = 0;
        for (ErrorType errorType: ErrorType.values()) {
            i++;
            if (errorType == ErrorType.FORBIDDEN || errorType == ErrorType.GATEWAY_TIMEOUT) {
                continue;
            }

            checkResponseType(errorType, Error.class);
            setUp();
        }
        assertTrue(i > 0);
    }

    @Test
    void parseCheckMissingStreamError() {
        when(rawContentResponse.getResponseBody()).thenReturn(Optional.empty());
        Object actual = sut.parse(rawContentResponse);

        assertTrue(actual instanceof ClientError);
    }

    @Test
    void parseCheckMalformedJSONError() throws IOException {
        testWithThrowable(new JsonParseException(null, "Test"));
    }

    @Test
    void parseCheckUnmappableObject() throws IOException {
        testWithThrowable(new JsonMappingException(null, "Test"));
    }

    @Test
    void parseCheckIOException() throws IOException {
        testWithThrowable(new IOException("Test"));
    }

    private void testWithThrowable(Exception exception) throws IOException {
        when(rawContentResponse.getErrorType()).thenReturn(ErrorType.BAD_REQUEST);
        when(objectMapper.readValue(eq(responseBody), any(TypeReference.class))).thenThrow(exception);
        Object actual = sut.parse(rawContentResponse);
        verify(objectMapper).readValue(eq(responseBody), any(TypeReference.class));
        assertTrue(actual instanceof ClientError);
    }

    private void checkResponseType(ErrorType errorType, Class<? extends Error> targetClass) throws IOException, ClassNotFoundException {
        ArgumentCaptor<TypeReference> argument = ArgumentCaptor.forClass(TypeReference.class);
        when(rawContentResponse.getErrorType()).thenReturn(errorType);
        sut.parse(rawContentResponse);

        verify(rawContentResponse).getErrorType();
        verify(objectMapper).readValue(eq(responseBody), argument.capture());
        TypeReference typeReference = argument.getValue();
        Class<?> receivedClass = Class.forName(typeReference.getType().getTypeName());
        assertTrue(targetClass.isAssignableFrom(receivedClass));
    }


}