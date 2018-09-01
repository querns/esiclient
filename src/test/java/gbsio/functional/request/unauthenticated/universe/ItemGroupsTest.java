package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.universe.ItemGroup;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.ItemGroupIDsRequest;
import gbsio.esiclient.client.request.universe.ItemGroupRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemGroupsTest extends FunctionalTestHarness {
    @Test
    void requests() {
        Client client = getClient();
        final Response<ImmutableList<Integer>> listResponse = client.sendRequest(new ItemGroupIDsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(listResponse);
        assertTrue(list.size() > 0);
        int groupID = list.get(0);

        final Response<ItemGroup> groupResponse = client.sendRequest(new ItemGroupRequest(groupID)).join();
        final ItemGroup group = assertResponseExistsAndGet(groupResponse);
        assertEquals(groupID, group.getID());
    }
}