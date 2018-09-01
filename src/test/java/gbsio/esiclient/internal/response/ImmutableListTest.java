package gbsio.esiclient.internal.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImmutableListTest {
    private static final int ONE = 1354830081;
    private static final int TWO = 99005338;
    private static final int THREE = 498125261;
    private static final Integer[] EXPECTED = new Integer[]{ONE, TWO, THREE};

    @Test
    void testParse() throws IOException {
        ImmutableList<Integer> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/immutableIntegerList.json"),
            new TypeReference<ImmutableList<Integer>>() { }
        );

        JsonTestHarness.assertForEach(
            list,
            EXPECTED.length,
            (index, expected) -> assertEquals(EXPECTED[index], expected)
        );
    }

    @Test
    void serialize() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(
            ImmutableList.builder().add(ONE, TWO, THREE).build()
        );

        assertTrue(node.isArray());
        assertEquals(3, node.size());
        assertEquals(ONE, node.get(0).asInt());
        assertEquals(TWO, node.get(1).asInt());
        assertEquals(THREE, node.get(2).asInt());
    }
}
