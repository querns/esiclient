package gbsio.functional.request.authenticated.mail;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.mail.Label;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.mail.MailingListSubscriptionsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailingListSubscriptionsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Label>> response = getClient().sendRequest(new MailingListSubscriptionsRequest(
            getPropertyAsInt("promfem_id"),
            getAccessToken("my_5s_token")
        )).join();

        final ImmutableList<Label> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}