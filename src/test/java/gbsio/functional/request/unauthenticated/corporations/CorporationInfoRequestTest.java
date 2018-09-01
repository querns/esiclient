package gbsio.functional.request.unauthenticated.corporations;

import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationInfoRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationInfoRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<CorporationInfo> response = getClient().sendRequest(new CorporationInfoRequest(
            getPropertyAsInt("goonwaffe_id")
        )).join();

        final CorporationInfo info = assertResponseExistsAndGet(response);
        //noinspection SpellCheckingInspection
        assertEquals("GoonWaffe", info.getName());
    }
}