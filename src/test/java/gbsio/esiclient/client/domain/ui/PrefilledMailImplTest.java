package gbsio.esiclient.client.domain.ui;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PrefilledMailImplTest {
    private static final String BODY = "body";
    private static final int RECIPIENT_ID = 123;
    private static final ImmutableList<Integer> RECIPIENTS = ImmutableList.of(RECIPIENT_ID);
    private static final String SUBJECT = "subject";
    private static final int CORPORATION_OR_ALLIANCE_RECIPIENT_ID = 234;

    @Test
    void serialize() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(new PrefilledMailBuilder.PrefilledMailImpl(
            BODY, RECIPIENTS, SUBJECT, CORPORATION_OR_ALLIANCE_RECIPIENT_ID, null
        ));

        assertTrue(node.has("body"));
        assertTrue(node.has("recipients"));
        assertTrue(node.has("subject"));
        assertTrue(node.has("to_corp_or_alliance_id"));
        assertFalse(node.has("to_mailing_list_id"));

        final JsonNode bodyNode = node.get("body");
        final JsonNode recipientNode = node.get("recipients");
        final JsonNode subjectNode = node.get("subject");
        final JsonNode mailingGroupNode = node.get("to_corp_or_alliance_id");

        assertTrue(bodyNode.isTextual());
        assertTrue(subjectNode.isTextual());
        assertTrue(recipientNode.isArray());
        assertTrue(mailingGroupNode.isNumber());

        assertEquals(BODY, bodyNode.asText());
        assertEquals(SUBJECT, subjectNode.asText());
        assertEquals(1, recipientNode.size());
        assertTrue(recipientNode.get(0).isNumber());
        assertEquals(RECIPIENT_ID, recipientNode.get(0).asInt());
        assertEquals(CORPORATION_OR_ALLIANCE_RECIPIENT_ID, mailingGroupNode.asInt());
    }
}