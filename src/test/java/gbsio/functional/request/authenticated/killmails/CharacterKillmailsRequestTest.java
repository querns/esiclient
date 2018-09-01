package gbsio.functional.request.authenticated.killmails;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.killmails.CharacterKillmailsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CharacterKillmailsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<KillmailIDHash>> response = getClient().sendRequest(new CharacterKillmailsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<KillmailIDHash> list = assertResponseExistsAndGet(response);
        assertNotNull(list);
    }
}