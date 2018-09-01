package gbsio.functional.request.authenticated.wallet;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.wallet.Transaction;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wallet.CharacterWalletTransactionsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CharacterWalletTransactionsRequestTest extends FunctionalTestHarness {
    @Test
    void requests() throws IOException {
        final Client client = getClient();
        final int characterID = getPropertyAsInt("querns_id");
        final String accessToken = getAccessToken("querns_token");
        final Response<ImmutableList<Transaction>> firstResponse = client.sendRequest(new CharacterWalletTransactionsRequest(
            characterID,
            accessToken
        )).join();

        final ImmutableList<Transaction> firstList = assertResponseExistsAndGet(firstResponse);
        if (firstList.size() == 0) {
            log("Unable to do followup character wallet transaction request due to lack of entries");
        } else {
            final Optional<Long> fromID = firstList.stream()
                .map(Transaction::getID)
                .sorted()
                .findFirst()
                ;

            fromID.ifPresent(id -> {
                final Response<ImmutableList<Transaction>> response = client.sendRequest(new CharacterWalletTransactionsRequest(
                    characterID, accessToken, id
                )).join();
                final ImmutableList<Transaction> list = assertResponseExistsAndGet(response);
                assertNotNull(list);
            });
        }
    }
}