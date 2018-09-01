package gbsio.functional.request.authenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.CharacterOrder;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.CharacterOrdersRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterOrdersRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CharacterOrder>> response = getClient().sendRequest(new CharacterOrdersRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<CharacterOrder> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
    }
}