package gbsio.functional.request.unauthenticated.opportunities;

import gbsio.esiclient.api.domain.response.opportunities.OpportunityTask;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.opportunities.OpportunityTaskRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTaskRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<OpportunityTask> response = getClient().sendRequest(new OpportunityTaskRequest(10)).join();
        final OpportunityTask task = assertResponseExistsAndGet(response);
        assertNotNull(task);
    }
}