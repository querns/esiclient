package gbsio.functional.request.authenticated.character;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.Notification;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.character.NotificationsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NotificationsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Notification>> response = getClient().sendRequest(new NotificationsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<Notification> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}