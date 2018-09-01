package gbsio.esiclient.client.domain.mail;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailMetadataImplTest {
    private static final int LABEL_ID = 123;
    private static final boolean IS_READ = true;

    @Test
    void serializeWithIsRead() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(new MailMetadataBuilder.MailMetadataImpl(ImmutableList.of(LABEL_ID), IS_READ));

        assertTrue(node.has("labels"));
        assertTrue(node.has("read"));

        JsonNode labelsNode = node.get("labels");
        JsonNode readNode = node.get("read");

        assertTrue(labelsNode.isArray());
        assertTrue(readNode.isBoolean());

        assertEquals(1, labelsNode.size());
        assertTrue(readNode.asBoolean());

        JsonNode labelIDNode = labelsNode.get(0);
        assertTrue(labelIDNode.isNumber());
        assertEquals(LABEL_ID, labelIDNode.asInt());
    }

    @Test
    void serializeWithoutIsRead() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(new MailMetadataBuilder.MailMetadataImpl(ImmutableList.of(LABEL_ID), null));

        assertTrue(node.has("labels"));
        assertFalse(node.has("read"));

        JsonNode labelsNode = node.get("labels");

        assertTrue(labelsNode.isArray());
        assertEquals(1, labelsNode.size());

        JsonNode labelIDNode = labelsNode.get(0);
        assertTrue(labelIDNode.isNumber());
        assertEquals(LABEL_ID, labelIDNode.asInt());
    }
}