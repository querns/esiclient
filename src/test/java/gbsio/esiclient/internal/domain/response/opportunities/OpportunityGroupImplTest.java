package gbsio.esiclient.internal.domain.response.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.opportunities.OpportunityGroup;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityGroupImplTest {
    @Test
    void parse() throws IOException {
        OpportunityGroup group = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/opportunities/group.json"),
            new TypeReference<OpportunityGroup>() { }
        );

        assertEquals("As a capsuleer...", group.getDescription());
        assertEquals(103, group.getID());
        assertEquals("Welcome to New Eden", group.getName());
        assertEquals("Completed:<br>Welcome to New Eden", group.getNotification());

        assertEquals(1, group.getConnectedGroupIDs().size());
        assertTrue(group.getConnectedGroupIDs().contains(100));

        assertEquals(1, group.getRequiredTaskIDs().size());
        assertTrue(group.getRequiredTaskIDs().contains(19));
    }
}