package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.errors.GatewayTimeoutError;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GatewayTimeoutErrorParseTest {
    @Test
    void testParse() throws IOException {
        GatewayTimeoutError gatewayTimeoutError = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/errors/gatewayTimeoutError.json"),
            new TypeReference<GatewayTimeoutError>() { }
        );

        assertEquals("Test Error", gatewayTimeoutError.getErrorMessage());
        assertEquals(60, gatewayTimeoutError.getTimeout());
    }
}