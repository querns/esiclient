package gbsio.functional.request.unauthenticated.opportunities;

import gbsio.esiclient.api.domain.response.opportunities.OpportunityGroup;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.opportunities.OpportunityGroupRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityGroupRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<OpportunityGroup> response = getClient().sendRequest(new OpportunityGroupRequest(100)).join();
        final OpportunityGroup group = assertResponseExistsAndGet(response);
        assertNotNull(group);
    }
}