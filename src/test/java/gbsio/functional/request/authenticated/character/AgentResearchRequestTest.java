package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.AgentResearch;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.AgentResearchRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AgentResearchRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<AgentResearch>> response = getClient().sendRequest(new AgentResearchRequest(
            getPropertyAsInt("researcher_id"),
            getAccessToken("researcher_token")
        )).join();

        final ImmutableList<AgentResearch> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}