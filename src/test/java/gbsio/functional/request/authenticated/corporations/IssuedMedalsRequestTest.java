package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.IssuedMedal;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.IssuedMedalsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IssuedMedalsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<IssuedMedal>> response = getClient().sendRequest(new IssuedMedalsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<IssuedMedal> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}