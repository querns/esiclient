package gbsio.functional.request.authenticated.clones;

import gbsio.esiclient.api.domain.response.clones.JumpCloneInformation;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.clones.JumpCloneInformationRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JumpCloneInformationRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<JumpCloneInformation> response = getClient().sendRequest(new JumpCloneInformationRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final JumpCloneInformation info = assertResponseExistsAndGet(response);
        assertNotNull(info);
        assertTrue(info.getJumpClones().size() > 0);
    }
}