package gbsio.functional.request.authenticated.industry;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.IndustryJob;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.industry.CorporationIndustryJobsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CorporationIndustryJobsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<IndustryJob>> response = getClient().sendRequest(new CorporationIndustryJobsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<IndustryJob> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
    }
}