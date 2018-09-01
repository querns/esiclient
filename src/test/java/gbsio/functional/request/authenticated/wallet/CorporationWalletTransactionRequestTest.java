package gbsio.functional.request.authenticated.wallet;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.wallet.Transaction;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wallet.CorporationWalletTransactionRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CorporationWalletTransactionRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final int corporationID = getPropertyAsInt("djs_id");
        final String accessToken = getAccessToken("djs_token");

        final Response<ImmutableList<Transaction>> response = client.sendRequest(new CorporationWalletTransactionRequest(
            corporationID,
            accessToken,
            1
        )).join();

        final ImmutableList<Transaction> list = assertResponseExistsAndGet(response);
        final Optional<Long> lastTransactionID = list.stream()
            .map(Transaction::getID)
            .sorted()
            .findFirst()
            ;

        lastTransactionID.ifPresent(transactionID -> {
            final Response<ImmutableList<Transaction>> responseTwo = client.sendRequest(new CorporationWalletTransactionRequest(
                corporationID, accessToken, 1, transactionID
            )).join();

            final ImmutableList<Transaction> listTwo = assertResponseExistsAndGet(responseTwo);
            assertNotNull(listTwo);
        });
    }
}