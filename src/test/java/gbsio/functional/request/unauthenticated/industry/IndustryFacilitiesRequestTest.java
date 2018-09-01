package gbsio.functional.request.unauthenticated.industry;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.Facility;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.industry.IndustryFacilitiesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IndustryFacilitiesRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Facility>> response = getClient().sendRequest(new IndustryFacilitiesRequest()).join();
        final ImmutableList<Facility> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}