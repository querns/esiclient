package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemJumpData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.JumpsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<SystemJumpData>> response = getClient().sendRequest(new JumpsRequest()).join();
        final ImmutableList<SystemJumpData> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}