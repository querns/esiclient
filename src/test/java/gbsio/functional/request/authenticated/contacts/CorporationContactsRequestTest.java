package gbsio.functional.request.authenticated.contacts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contacts.CorporationContactsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationContactsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<BaseContact>> response = getClient().sendRequest(new CorporationContactsRequest(
            getPropertyAsInt("my_5s_id"),
            getAccessToken("my_5s_token")
        )).join();

        final ImmutableList<BaseContact> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}