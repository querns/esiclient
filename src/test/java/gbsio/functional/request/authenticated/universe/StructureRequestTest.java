package gbsio.functional.request.authenticated.universe;

import gbsio.esiclient.api.domain.response.universe.Structure;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.StructureRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StructureRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        //noinspection SpellCheckingInspection
        final Response<Structure> response = getClient().sendRequest(new StructureRequest(
            getPropertyAsLong("thetastar_structure_id"),
            getAccessToken("querns_token")
        )).join();

        final Structure structure = assertResponseExistsAndGet(response);
        assertTrue(structure.getItemTypeID().isPresent());
        assertEquals(35834, structure.getItemTypeID().get().intValue());
    }
}