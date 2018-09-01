package gbsio.functional.request.unauthenticated.industry;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.CostIndexData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.industry.CostIndexesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostIndexesRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<CostIndexData>> response = getClient().sendRequest(new CostIndexesRequest()).join();
        final ImmutableList<CostIndexData> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}