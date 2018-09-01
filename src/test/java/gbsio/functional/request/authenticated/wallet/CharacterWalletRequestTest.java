package gbsio.functional.request.authenticated.wallet;

import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wallet.CharacterWalletRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CharacterWalletRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<Double> response = getClient().sendRequest(new CharacterWalletRequest(
            getPropertyAsInt("querns_id"),
            getAccessToken("querns_token")
        )).join();

        double walletAmount = assertResponseExistsAndGet(response);
        assertTrue(walletAmount > 0D);
    }
}