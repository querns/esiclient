package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberRoles;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.MemberRolesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRolesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<MemberRoles>> response = getClient().sendRequest(new MemberRolesRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<MemberRoles> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}