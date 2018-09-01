package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTitles;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.MemberTitlesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberTitlesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<MemberTitles>> response = getClient().sendRequest(new MemberTitlesRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<MemberTitles> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}