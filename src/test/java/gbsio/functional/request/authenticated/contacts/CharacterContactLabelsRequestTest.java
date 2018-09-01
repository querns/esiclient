package gbsio.functional.request.authenticated.contacts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.ContactLabel;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contacts.CharacterContactLabelsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterContactLabelsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<ContactLabel>> response = getClient().sendRequest(new CharacterContactLabelsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<ContactLabel> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}