package gbsio.functional.request.unauthenticated.alliance;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.alliance.AllianceCorporationsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AllianceCorporationsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Integer>> response = getClient().sendRequest(
            new AllianceCorporationsRequest(Integer.valueOf(getProperty("querns_id")))
        ).join();


    }
}