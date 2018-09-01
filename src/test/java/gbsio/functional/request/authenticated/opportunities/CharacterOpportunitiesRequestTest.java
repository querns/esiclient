package gbsio.functional.request.authenticated.opportunities;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.opportunities.CompletionData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.opportunities.CharacterOpportunitiesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterOpportunitiesRequestTest extends FunctionalTestHarness {
    @Test
    @Disabled("Endpoint is bugged on CCP side")
    void request() throws IOException {
        final Response<ImmutableList<CompletionData>> response = getClient().sendRequest(new CharacterOpportunitiesRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<CompletionData> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}