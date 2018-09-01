package gbsio.functional.request.authenticated.market;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.market.CharacterOrder;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.market.CharacterOrderHistoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CharacterOrderHistoryRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CharacterOrder>> response = getClient().sendRequest(new CharacterOrderHistoryRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<CharacterOrder> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
    }
}