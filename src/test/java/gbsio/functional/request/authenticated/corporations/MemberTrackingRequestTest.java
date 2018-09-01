package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.MemberTrackingData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.MemberTrackingRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MemberTrackingRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<MemberTrackingData>> response = getClient().sendRequest(new MemberTrackingRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<MemberTrackingData> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}