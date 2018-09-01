package gbsio.functional.request.authenticated.wallet;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.JournalEntry;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wallet.CorporationWalletJournalRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationWalletJournalRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<JournalEntry>> response = getClient().sendRequest(new CorporationWalletJournalRequest(
            getPropertyAsInt("djs_id"),
            getAccessToken("djs_token"),
            1
        )).join();

        final ImmutableList<JournalEntry> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}