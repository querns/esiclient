package gbsio.functional.request.unauthenticated.dogma;

import gbsio.esiclient.api.domain.response.dogma.DynamicItem;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.dogma.DynamicItemRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DynamicItemRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<DynamicItem> response = getClient().sendRequest(new DynamicItemRequest(
            getPropertyAsLong("abyssal_plate_item_id"),
            getPropertyAsInt("abyssal_plate_item_type_id")
        )).join();

        final DynamicItem item = assertResponseExistsAndGet(response);
        assertNotNull(item);
        assertEquals(11295, item.getSourceItemTypeID());
    }
}