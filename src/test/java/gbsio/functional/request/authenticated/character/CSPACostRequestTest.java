package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CSPACostRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CSPACostRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<Float> response = getClient().sendRequest(new CSPACostRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token"),
            ImmutableList.of(getPropertyAsInt("promfem_id"))
        )).join();

        final Float cost = assertResponseExistsAndGet(response);
        assertNotNull(cost);
    }
}