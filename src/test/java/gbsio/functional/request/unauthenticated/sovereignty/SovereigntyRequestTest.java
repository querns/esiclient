package gbsio.functional.request.unauthenticated.sovereignty;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.sovereignty.Sovereignty;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.sovereignty.SovereigntyRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SovereigntyRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Sovereignty>> response = getClient().sendRequest(new SovereigntyRequest()).join();
        final ImmutableList<Sovereignty> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}