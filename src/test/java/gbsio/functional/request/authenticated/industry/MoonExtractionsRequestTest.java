package gbsio.functional.request.authenticated.industry;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MoonExtractionTimer;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.industry.MoonExtractionsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MoonExtractionsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<MoonExtractionTimer>> response = getClient().sendRequest(new MoonExtractionsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<MoonExtractionTimer> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}