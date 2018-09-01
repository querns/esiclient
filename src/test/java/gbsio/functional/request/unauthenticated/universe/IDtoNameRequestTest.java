package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.IDtoNameResults;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.IDtoNameRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IDtoNameRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final int quernsID = getPropertyAsInt("querns_id");
        final int jitaSolarSystemID = getPropertyAsInt("jita_solar_system_id");

        final Response<ImmutableList<IDtoNameResults>> response = getClient().sendRequest(new IDtoNameRequest(
            ImmutableList.of(quernsID, jitaSolarSystemID)
        )).join();
        final ImmutableList<IDtoNameResults> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() >= 2);

        assertTrue(list.stream()
            .anyMatch(iDtoNameResults -> iDtoNameResults.getCategory() == IDtoNameResults.Category.SOLAR_SYSTEM
                && iDtoNameResults.getName().equals("Jita")
            )
        );

        assertTrue(list.stream()
            .anyMatch(iDtoNameResults -> iDtoNameResults.getCategory() == IDtoNameResults.Category.CHARACTER
                && iDtoNameResults.getName().equals("Querns")
            )
        );
    }
}