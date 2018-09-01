package gbsio.esiclient.client.domain.fleets;

import com.fasterxml.jackson.databind.JsonNode;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.request.fleets.FleetInvitation;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FleetInvitationImplTest {
    private static final int CHARACTER_ID = 12345;
    private static final long SQUAD_ID = 2L;
    private static final long WING_ID = 3L;
    private static final Role ROLE = Role.SQUAD_MEMBER;

    @Test
    void serializeBothPresent() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(
            new FleetInvitationBuilder.FleetInvitationImpl(CHARACTER_ID, ROLE, SQUAD_ID, WING_ID)
        );

        assertTrue(node.has("character_id"));
        assertTrue(node.has("role"));
        assertTrue(node.has("squad_id"));
        assertTrue(node.has("wing_id"));

        final JsonNode characterIDNode = node.get("character_id");
        final JsonNode roleNode = node.get("role");
        final JsonNode squadIDNode = node.get("squad_id");
        final JsonNode wingIDNode = node.get("wing_id");

        assertTrue(characterIDNode.isNumber());
        assertTrue(roleNode.isTextual());
        assertTrue(squadIDNode.isNumber());
        assertTrue(wingIDNode.isNumber());

        assertEquals(CHARACTER_ID, characterIDNode.asInt());
        assertEquals(ROLE.getIdentifier(), roleNode.asText());
        assertEquals(SQUAD_ID, squadIDNode.asLong());
        assertEquals(WING_ID, wingIDNode.asLong());
    }

    @Test
    void serializeBothMissing() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(
            FleetInvitation.squadMember(CHARACTER_ID)
        );

        assertTrue(node.has("character_id"));
        assertTrue(node.has("role"));
        assertFalse(node.has("squad_id"));
        assertFalse(node.has("wing_id"));
    }
}