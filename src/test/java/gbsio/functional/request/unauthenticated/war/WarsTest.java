package gbsio.functional.request.unauthenticated.war;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.killmails.KillmailIDHash;
import gbsio.esiclient.api.domain.response.wars.War;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wars.WarIDsRequest;
import gbsio.esiclient.client.request.wars.WarKillmailHashesRequest;
import gbsio.esiclient.client.request.wars.WarRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WarsTest extends FunctionalTestHarness {
    @Test
    void request() {
        final Client client = getClient();
        final Response<ImmutableList<Integer>> response = client.sendRequest(new WarIDsRequest()).join();
        final ImmutableList<Integer> list = assertResponseExistsAndGet(response);

        final Optional<Integer> warID = list.stream()
            .sorted()
            .findFirst();

        assertTrue(warID.isPresent());
        final Response<ImmutableList<Integer>> secondResponse = client.sendRequest(
            new WarIDsRequest(warID.get())
        ).join();

        final ImmutableList<Integer> secondList = assertResponseExistsAndGet(secondResponse);
        assertTrue(secondList.size() > 0);

        final Response<War> warResponse = client.sendRequest(
            new WarRequest(warID.get())
        ).join();
        final War war = assertResponseExistsAndGet(warResponse);
        assertEquals(warID.get().intValue(), war.getID());

        final Response<ImmutableList<KillmailIDHash>> killsResponse = client.sendRequest(
            new WarKillmailHashesRequest(warID.get())
        ).join();
        final ImmutableList<KillmailIDHash> hashList = assertResponseExistsAndGet(killsResponse);
        assertNotNull(hashList);
    }
}