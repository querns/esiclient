package gbsio.functional.request.unauthenticated.sovereignty;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Campaign;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.sovereignty.CampaignsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Campaign>> response = getClient().sendRequest(new CampaignsRequest()).join();
        final ImmutableList<Campaign> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}