package gbsio.functional.request.authenticated.planetaryinteraction;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.CustomsOffice;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.planetaryinteraction.CustomsOfficesRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomsOfficesRequestTest extends FunctionalTestHarness {
    @Test
    @Disabled("Server throws a 500 error")
    void request() throws IOException {
        final Response<ImmutableList<CustomsOffice>> response = getClient().sendRequest(new CustomsOfficesRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<CustomsOffice> list = assertResponseExistsAndGet(response);
        log(String.valueOf(list.size()));
        assertTrue(list.size() > 0);
    }
}