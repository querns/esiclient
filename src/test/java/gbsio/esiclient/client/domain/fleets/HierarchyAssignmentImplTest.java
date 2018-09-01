package gbsio.esiclient.client.domain.fleets;

import com.fasterxml.jackson.databind.JsonNode;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HierarchyAssignmentImplTest {
    private static final long SQUAD_ID = 1L;
    private static final Role ROLE = Role.SQUAD_MEMBER;
    private static final long WING_ID = 2L;

    @Test
    void serialize() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(new HierarchyAssignmentBuilder.HierarchyAssignmentImpl(ROLE, SQUAD_ID, WING_ID));

        assertTrue(node.has("role"));
        assertTrue(node.has("squad_id"));
        assertTrue(node.has("wing_id"));

        JsonNode roleNode = node.get("role");
        JsonNode squadIDNode = node.get("squad_id");
        JsonNode wingIDNode = node.get("wing_id");

        assertEquals(ROLE.getIdentifier(), roleNode.asText());
        assertEquals(SQUAD_ID, squadIDNode.asLong());
        assertEquals(WING_ID, wingIDNode.asLong());
    }
}