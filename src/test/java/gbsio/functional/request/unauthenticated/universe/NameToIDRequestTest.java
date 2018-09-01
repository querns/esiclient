package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.response.universe.NameToIDResults;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.NameToIDRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameToIDRequestTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Response<NameToIDResults> response = getClient().sendRequest(new NameToIDRequest(
            ImmutableSet.of("Querns", "1DQ1-A")
        )).join();

        final NameToIDResults results = assertResponseExistsAndGet(response);
        assertTrue(results.getCharacters().size() > 0);
        assertTrue(results.getSolarSystems().size() > 0);
    }
}