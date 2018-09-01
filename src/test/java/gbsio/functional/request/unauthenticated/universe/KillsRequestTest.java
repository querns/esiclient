package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemKillData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.KillsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KillsRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<SystemKillData>> response = getClient().sendRequest(new KillsRequest()).join();
        final ImmutableList<SystemKillData> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}