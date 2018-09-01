package gbsio.functional.request.authenticated.killmails;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.killmails.Killmail;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.killmails.CorporationKillmailsRequest;
import gbsio.esiclient.client.request.killmails.KillmailRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationKillmailsTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        Client client = getClient();
        final Response<ImmutableList<KillmailIDHash>> killmailHashesResponse = client.sendRequest(new CorporationKillmailsRequest(
            getPropertyAsInt("goonwaffe_id"),
            getAccessToken("goonwaffe_token")
        )).join();

        final ImmutableList<KillmailIDHash> hashList = assertResponseExistsAndGet(killmailHashesResponse);
        assertTrue(hashList.size() > 0);
        final KillmailIDHash idHash = hashList.get(0);

        final Response<Killmail> killmailResponse = client.sendRequest(new KillmailRequest(idHash)).join();
        final Killmail killmail = assertResponseExistsAndGet(killmailResponse);
        assertNotNull(killmail);
    }
}