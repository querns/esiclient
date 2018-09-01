package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.CorporationTitle;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationTitlesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationTitlesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CorporationTitle>> response = getClient().sendRequest(new CorporationTitlesRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<CorporationTitle> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}