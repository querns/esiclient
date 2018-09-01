package gbsio.functional.request.unauthenticated.universe;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.universe.Graphic;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.GraphicIDsRequest;
import gbsio.esiclient.client.request.universe.GraphicRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphicsTest extends FunctionalTestHarness {
    @Test
    void requests() {
        final Client client = getClient();

        final Response<ImmutableList<Integer>> listResponse = client.sendRequest(new GraphicIDsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(listResponse);
        assertTrue(list.size() > 0);

        final Integer graphicID = list.get(0);
        final Response<Graphic> graphicResponse = client.sendRequest(
            new GraphicRequest(graphicID)
        ).join();
        final Graphic graphic = assertResponseExistsAndGet(graphicResponse);

        assertEquals(graphicID.intValue(), graphic.getID());
    }
}