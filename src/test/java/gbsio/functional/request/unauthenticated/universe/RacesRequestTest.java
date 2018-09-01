package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Race;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.RacesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacesRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Race>> response = getClient().sendRequest(new RacesRequest()).join();
        final ImmutableList<Race> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}