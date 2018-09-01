package gbsio.esiclient.internal.json.deserializers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LongUnpackingDeserializerTest {
    private final static Long TEST_VALUE = 1234567890123L;
    @Test
    void deserializeBoxed() throws IOException {
        final String boxedLongJson = String.format("{\"linux\": %d}", TEST_VALUE);
        Long output = JsonTestHarness.deserialize(boxedLongJson, new TypeReference<Long>() { });

        assertEquals(TEST_VALUE, output);
    }

    @Test
    void deserializeRawValue() throws IOException {
        final String longJson = String.format("%d", TEST_VALUE);
        Long output = JsonTestHarness.deserialize(longJson, new TypeReference<Long>() { });

        assertEquals(TEST_VALUE, output);
    }

    @Test
    void deserializeNegativeInteger() throws IOException {
        final String longJson = "-1";
        Long output = JsonTestHarness.deserialize(longJson, new TypeReference<Long>() { });

        assertEquals((Long)(-1L), output);
    }

    @Test
    void deserializeArray() throws IOException {
        final String arrayJson = String.format("[%d, %d]", TEST_VALUE, TEST_VALUE);
        ImmutableList<Long> output = JsonTestHarness.deserialize(arrayJson, new TypeReference<ImmutableList<Long>>() { });

        assertNotNull(output);
        assertEquals(2, output.size());
        assertEquals(TEST_VALUE, output.get(0));
        assertEquals(TEST_VALUE, output.get(1));
    }
}