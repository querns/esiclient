package gbsio.esiclient.client.domain.mail;

import com.fasterxml.jackson.databind.JsonNode;
import gbsio.esiclient.api.domain.common.mail.Recipient;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NewMailImplTest {
    private static final String SUBJECT = "Subject";
    private static final String BODY = "Body";
    private static final Recipient.Type RECIPIENT_TYPE = Recipient.Type.CHARACTER;
    private static final int CHARACTER_ID = 1;
    private static final double APPROVED_COST = 1.23D;

    @Test
    void serializeWithApprovedCost() throws IOException {
        NewMailBuilder builder = getNewMailBuilder();
        builder.setApprovedCost(APPROVED_COST);

        JsonNode node = JsonTestHarness.serializeToNode(builder.build());

        validateCommonParameters(node);

        assertTrue(node.has("approved_cost"));
        JsonNode approvedCostNode = node.get("approved_cost");

        assertEquals(APPROVED_COST, approvedCostNode.asDouble());
    }

    @Test
    void serializeWithoutApprovedCost() throws IOException {
        NewMailBuilder builder = getNewMailBuilder();
        JsonNode node = JsonTestHarness.serializeToNode(builder.build());

        validateCommonParameters(node);
    }

    private void validateCommonParameters(final JsonNode node) {
        assertTrue(node.has("body"));
        assertTrue(node.has("subject"));
        assertTrue(node.has("recipients"));

        JsonNode bodyNode = node.get("body");
        JsonNode subjectNode = node.get("subject");
        JsonNode recipientsNode = node.get("recipients");
        assertTrue(bodyNode.isTextual());
        assertTrue(subjectNode.isTextual());
        assertTrue(recipientsNode.isArray());

        assertEquals(BODY, bodyNode.asText());
        assertEquals(SUBJECT, subjectNode.asText());

        assertEquals(1, recipientsNode.size());
        JsonNode recipientNode = recipientsNode.get(0);

        assertTrue(recipientNode.has("recipient_id"));
        assertTrue(recipientNode.has("recipient_type"));
        JsonNode idNode = recipientNode.get("recipient_id");
        JsonNode typeNode = recipientNode.get("recipient_type");

        assertTrue(idNode.isNumber());
        assertTrue(typeNode.isTextual());

        assertEquals(CHARACTER_ID, idNode.asInt());
        assertEquals(RECIPIENT_TYPE.getIdentifier(), typeNode.asText());
    }

    private NewMailBuilder getNewMailBuilder() {
        NewMailBuilder builder = new NewMailBuilder(BODY, SUBJECT);
        builder.addRecipient(CHARACTER_ID, RECIPIENT_TYPE);
        return builder;
    }
}