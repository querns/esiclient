package gbsio.esiclient.client.domain.fleets;

import com.fasterxml.jackson.databind.JsonNode;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FleetUpdateBuilderTest {
    private final static boolean FREE_MOVE = true;
    private final static String MOTD = "new MOTD";
    @Test
    void invariants() {
        FleetUpdateBuilder builder = new FleetUpdateBuilder();

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void serializeBothPresent() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(
            new FleetUpdateBuilder(FREE_MOVE, MOTD).build()
        );

        assertTrue(node.has("is_free_move"));
        assertTrue(node.has("motd"));

        JsonNode isFreeMove = node.get("is_free_move");
        JsonNode motd = node.get("motd");

        assertTrue(isFreeMove.isBoolean());
        assertTrue(motd.isTextual());

        assertEquals(FREE_MOVE, isFreeMove.asBoolean());
        assertEquals(MOTD, motd.asText());
    }

    @Test
    void serializeOnePresent() throws IOException {
        JsonNode node = JsonTestHarness.serializeToNode(
            new FleetUpdateBuilder().setFreeMove(FREE_MOVE).build()
        );

        assertTrue(node.has("is_free_move"));
        assertFalse(node.has("motd"));

        JsonNode isFreeMove = node.get("is_free_move");
        assertTrue(isFreeMove.isBoolean());
        assertEquals(FREE_MOVE, isFreeMove.asBoolean());
    }
}