package gbsio.functional.request.unauthenticated.factionwarfare;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.OccupiedSolarSystem;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.OccupiedSolarSystemRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OccupiedSolarSystemRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<OccupiedSolarSystem>> response = getClient().sendRequest(new OccupiedSolarSystemRequest()).join();
        final ImmutableList<OccupiedSolarSystem> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}