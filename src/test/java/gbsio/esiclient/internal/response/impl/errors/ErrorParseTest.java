package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.errors.Error;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorParseTest {
    private final static String ERROR_VALUE = "Test Error";

    @Test
    void testParse() throws IOException {
        Error error = JsonTestHarness.deserialize(
            "{\"error\": \"".concat(ERROR_VALUE).concat("\"}"),
            new TypeReference<Error>() { }
        );

        assertEquals(ERROR_VALUE, error.getErrorMessage());
    }
}