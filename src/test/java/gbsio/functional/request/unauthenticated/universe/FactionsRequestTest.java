package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.Faction;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.FactionsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactionsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<Faction>> response = getClient().sendRequest(new FactionsRequest()).join();
        final ImmutableList<Faction> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}