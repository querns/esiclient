package gbsio.functional.request.unauthenticated.factionwarfare;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.factionwarfare.WarOpponent;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.factionwarfare.WarOpponentRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarOpponentRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<ImmutableList<WarOpponent>> response = getClient().sendRequest(new WarOpponentRequest()).join();
        final ImmutableList<WarOpponent> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}