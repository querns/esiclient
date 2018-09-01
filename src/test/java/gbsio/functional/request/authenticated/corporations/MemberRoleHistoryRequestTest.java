package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.RoleHistoryEntry;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.MemberRoleHistoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MemberRoleHistoryRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<RoleHistoryEntry>> response = getClient().sendRequest(new MemberRoleHistoryRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<RoleHistoryEntry> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}