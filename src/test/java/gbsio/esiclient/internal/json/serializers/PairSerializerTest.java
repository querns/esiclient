package gbsio.esiclient.internal.json.serializers;

import com.fasterxml.jackson.databind.JsonNode;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairSerializerTest {
    private static final int VALUE0 = 1;
    private static final String VALUE1 = "linux";

    @Test
    void serialize() throws IOException {
        Pair<Integer, String> pair = new Pair<>(VALUE0, VALUE1);
        JsonNode node = JsonTestHarness.serializeToNode(pair);

        assertTrue(node.isArray());
        assertEquals(2, node.size());
        JsonNode one = node.get(0);
        JsonNode two = node.get(1);

        assertTrue(one.isNumber());
        assertTrue(two.isTextual());

        assertEquals(VALUE0, one.asInt());
        assertEquals(VALUE1, two.asText());
    }
}