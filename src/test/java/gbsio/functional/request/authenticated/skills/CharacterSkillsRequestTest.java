package gbsio.functional.request.authenticated.skills;

import gbsio.esiclient.api.domain.response.skills.TrainedSkillInfo;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.skills.CharacterSkillsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterSkillsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<TrainedSkillInfo> response = getClient().sendRequest(new CharacterSkillsRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        final TrainedSkillInfo skills = assertResponseExistsAndGet(response);
        assertNotNull(skills);
        assertTrue(skills.getSkills().size() > 0);
    }
}