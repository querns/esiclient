package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesParseTest {
    @Test
    void testParse() throws IOException {
        Coordinates position = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/common/position.json"),
            new TypeReference<Coordinates>() { }
        );

        assertEquals(12345.6, position.getX());
        assertEquals(23456.7, position.getY());
        assertEquals(34567.8, position.getZ());
    }
}