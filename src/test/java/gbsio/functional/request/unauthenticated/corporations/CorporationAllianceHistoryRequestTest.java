package gbsio.functional.request.unauthenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.AllianceHistory;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.CorporationAllianceHistoryRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationAllianceHistoryRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<AllianceHistory>> response = getClient().sendRequest(new CorporationAllianceHistoryRequest(
            getPropertyAsInt("goonwaffe_id")
        )).join();

        final ImmutableList<AllianceHistory> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}