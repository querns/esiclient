package gbsio.functional.request.authenticated.corporations;

import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.MemberLimitRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberLimitRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<Integer> response = getClient().sendRequest(new MemberLimitRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        Integer limit = assertResponseExistsAndGet(response);
        assertTrue(limit > 0);
    }
}