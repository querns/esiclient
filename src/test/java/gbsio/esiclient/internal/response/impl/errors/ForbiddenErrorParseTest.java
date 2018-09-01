package gbsio.esiclient.internal.response.impl.errors;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.errors.ForbiddenError;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForbiddenErrorParseTest {

    @Test
    void testParse() throws IOException {
        ForbiddenError forbiddenError = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/errors/forbiddenError.json"),
            new TypeReference<ForbiddenError>() { }
        );

        assertEquals("Test Error", forbiddenError.getErrorMessage());
        assertEquals(69, forbiddenError.getSsoStatus());
    }
}