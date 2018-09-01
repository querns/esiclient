package gbsio.functional.request.unauthenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CorporationHistoryEntry;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.CorporationHistoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationHistoryRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CorporationHistoryEntry>> response = getClient().sendRequest(new CorporationHistoryRequest(
            getPropertyAsInt("querns_id")
        )).join();

        final ImmutableList<CorporationHistoryEntry> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}