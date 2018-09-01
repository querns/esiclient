package gbsio.functional.request.authenticated.industry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.industry.MiningObserver;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.industry.MiningObserverRequest;
import gbsio.esiclient.client.request.industry.ObservedMiningDataRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class MiningLedgerTest extends FunctionalTestHarness {
    @Test
    void requestLedger() throws IOException {
        Client client = getClient();
        final int corporationID = getPropertyAsInt("goonwaffe_id");
        final String accessToken = getAccessToken("goonwaffe_token");

        final Response<ImmutableList<MiningObserver>> observersResponse = client.sendRequest(new MiningObserverRequest(
            corporationID, accessToken
        )).join();

        final ImmutableList<MiningObserver> observerList = assertResponseExistsAndGet(observersResponse);
        assertTrue(observerList.size() > 0);

        Lists.partition(observerList, 100).forEach(observers -> observers.stream()
            .map(miningObserver ->
                client.sendRequest(new ObservedMiningDataRequest(
                    corporationID, accessToken, miningObserver.getID()
                ))
            )
            .map(CompletableFuture::join)
            .map(FunctionalTestHarness::assertResponseExistsAndGet)
            .forEach(Assertions::assertNotNull)
        );
    }
}