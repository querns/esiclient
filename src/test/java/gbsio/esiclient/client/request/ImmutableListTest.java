package gbsio.esiclient.client.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImmutableListTest {
    @Test
    void testSerializeList() throws JsonProcessingException {
        ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
        String actual = JsonTestHarness.serialize(list);
        assertEquals("[1,2,3]", actual);
    }
}
