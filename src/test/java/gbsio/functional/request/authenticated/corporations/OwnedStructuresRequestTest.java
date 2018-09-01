package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.OwnedStructure;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.OwnedStructuresRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OwnedStructuresRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<OwnedStructure>> response = getClient().sendRequest(new OwnedStructuresRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<OwnedStructure> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}