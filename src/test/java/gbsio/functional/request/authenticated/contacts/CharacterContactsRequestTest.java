package gbsio.functional.request.authenticated.contacts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.CharacterContact;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contacts.CharacterContactsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterContactsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CharacterContact>> response = getClient().sendRequest(new CharacterContactsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<CharacterContact> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}