package gbsio.esiclient.client.domain.mail;

import com.fasterxml.jackson.databind.JsonNode;
import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NewLabelImplTest {
    private static final LabelColor LABEL_COLOR = LabelColor.COLOR_006634;
    private static final String NAME = "name";

    @Test
    void serializeWithColor() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(new NewLabelBuilder.NewLabelImpl(LABEL_COLOR, NAME));

        assertEquals(2, node.size());
        assertTrue(node.has("color"));
        assertTrue(node.has("name"));

        final JsonNode colorNode = node.get("color");
        final JsonNode nameNode = node.get("name");

        assertTrue(colorNode.isTextual());
        assertTrue(nameNode.isTextual());

        assertEquals(LABEL_COLOR.getIdentifier(), colorNode.asText());
        assertEquals(NAME, nameNode.asText());
    }

    @Test
    void parseWithoutColor() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(new NewLabelBuilder.NewLabelImpl(null, NAME));

        assertEquals(1, node.size());
        assertFalse(node.has("color"));
        assertTrue(node.has("name"));
    }
}