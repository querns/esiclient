package gbsio.functional.request.unauthenticated.sovereignty;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Structure;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.sovereignty.SovereigntyStructuresRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SovereigntyStructuresRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Structure>> response = getClient().sendRequest(new SovereigntyStructuresRequest()).join();
        final ImmutableList<Structure> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}