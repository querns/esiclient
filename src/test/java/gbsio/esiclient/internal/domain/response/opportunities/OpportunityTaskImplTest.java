package gbsio.esiclient.internal.domain.response.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.opportunities.OpportunityTask;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTaskImplTest {
    @Test
    void parse() throws IOException {
        OpportunityTask task = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/opportunities/task.json"),
            new TypeReference<OpportunityTask>() { }
        );

        assertEquals("To use station services...", task.getDescription());
        assertEquals("Dock in the station", task.getName());
        assertEquals("Completed:<br>Docked in a station!", task.getNotification());
        assertEquals(10, task.getID());
    }
}