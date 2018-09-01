package gbsio.functional.request.authenticated.skills;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.skills.SkillQueueEntry;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.skills.SkillQueueRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SkillQueueRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<SkillQueueEntry>> response = getClient().sendRequest(new SkillQueueRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final ImmutableList<SkillQueueEntry> queue = assertResponseExistsAndGet(response);
        assertNotNull(queue);
    }
}