package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.Shareholder;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.ShareholdersRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShareholdersRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Shareholder>> response = getClient().sendRequest(new ShareholdersRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<Shareholder> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}