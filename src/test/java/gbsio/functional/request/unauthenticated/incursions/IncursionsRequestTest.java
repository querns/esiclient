package gbsio.functional.request.unauthenticated.incursions;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.incursions.Incursion;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.incursions.IncursionsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncursionsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Incursion>> response = getClient().sendRequest(new IncursionsRequest()).join();
        final ImmutableList<Incursion> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}