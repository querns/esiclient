package gbsio.functional.request.authenticated.corporations;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.ContainerAuditLog;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.corporations.ContainerAuditLogsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainerAuditLogsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<ContainerAuditLog>> response = getClient().sendRequest(new ContainerAuditLogsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<ContainerAuditLog> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
    }
}