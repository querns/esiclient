package gbsio.functional.request.unauthenticated.dogma;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.dogma.DogmaAttribute;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.dogma.DogmaAttributeDetailRequest;
import gbsio.esiclient.client.request.dogma.DogmaAttributesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogmaAttributesTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Client client = getClient();
        final Response<ImmutableList<Integer>> listResponse = client.sendRequest(new DogmaAttributesRequest()).join();

        final ImmutableList<Integer> list = assertResponseExistsAndGet(listResponse);
        assertTrue(list.size() > 0);
        Integer attributeID = list.get(0);

        final Response<DogmaAttribute> attributeResponse = client.sendRequest(new DogmaAttributeDetailRequest(attributeID)).join();
        final DogmaAttribute attribute = assertResponseExistsAndGet(attributeResponse);
        assertNotNull(attribute);
    }
}