package gbsio.functional.request.authenticated.contacts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.contacts.BaseContact;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contacts.AllianceContactsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AllianceContactsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<BaseContact>> response = getClient().sendRequest(new AllianceContactsRequest(
            getPropertyAsInt("goonswarm_federation_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<BaseContact> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}