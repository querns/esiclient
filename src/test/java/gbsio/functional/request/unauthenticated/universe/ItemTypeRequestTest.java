package gbsio.functional.request.unauthenticated.universe;

import gbsio.esiclient.api.domain.response.universe.ItemType;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.ItemTypeRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ItemTypeRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ItemType> response = getClient().sendRequest(new ItemTypeRequest(
            getPropertyAsInt("claw_item_type_id")
        )).join();
        final ItemType itemType = assertResponseExistsAndGet(response);
        assertEquals("Claw", itemType.getName());
    }
}