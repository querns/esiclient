package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.Facility;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationFacilitiesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationFacilitiesRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<Facility>> response = getClient().sendRequest(new CorporationFacilitiesRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<Facility> list = assertResponseExistsAndGet(response);

        assertTrue(list.size() > 0);
    }
}