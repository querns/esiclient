package gbsio.functional.request.authenticated.wallet;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.JournalEntry;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wallet.CharacterWalletJournalRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterWalletJournalRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<JournalEntry>> response = getClient().sendRequest(new CharacterWalletJournalRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();
        final ImmutableList<JournalEntry> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
    }
}