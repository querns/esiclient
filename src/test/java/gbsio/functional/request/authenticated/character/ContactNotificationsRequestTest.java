package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.ContactNotification;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.ContactNotificationsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContactNotificationsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<ContactNotification>> response = getClient().sendRequest(new ContactNotificationsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        assertResponseExistsAndGet(response);
    }
}