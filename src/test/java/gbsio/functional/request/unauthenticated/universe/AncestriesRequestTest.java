package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Ancestry;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.AncestriesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AncestriesRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Ancestry>> response = getClient().sendRequest(new AncestriesRequest()).join();
        final ImmutableList<Ancestry> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}