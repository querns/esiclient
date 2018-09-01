package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.universe.ItemCategory;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.ItemCategoryIDsRequest;
import gbsio.esiclient.client.request.universe.ItemCategoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCategoryTest extends FunctionalTestHarness {
    @Test
    void requests() {
        final Client client = getClient();
        final Response<ImmutableList<Integer>> listResponse = client.sendRequest(new ItemCategoryIDsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(listResponse);

        assertTrue(list.size() > 0);
        final int categoryID = list.get(0);

        final Response<ItemCategory> categoryResponse = client.sendRequest(new ItemCategoryRequest(categoryID)).join();
        final ItemCategory category = assertResponseExistsAndGet(categoryResponse);
        assertEquals(categoryID, category.getID());
    }
}