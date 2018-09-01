package gbsio.functional.request.authenticated.contacts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.ContactLabel;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contacts.CorporationContactLabelsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CorporationContactLabelsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<ContactLabel>> response = getClient().sendRequest(new CorporationContactLabelsRequest(
            getPropertyAsInt("my_5s_id"),
            getAccessToken("my_5s_token")
        )).join();

        final ImmutableList<ContactLabel> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}