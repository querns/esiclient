package gbsio.functional.request.authenticated.industry;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.MiningReport;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.industry.MiningLedgerRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MiningLedgerRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<MiningReport>> response = getClient().sendRequest(new MiningLedgerRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<MiningReport> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
    }
}