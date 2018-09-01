package gbsio.functional.request.authenticated.wallet;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.CorporationWallet;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.wallet.CorporationWalletsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CorporationWalletsRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Response<ImmutableList<CorporationWallet>> response = getClient().sendRequest(new CorporationWalletsRequest(
            getPropertyAsInt("djs_id"),
            getAccessToken("djs_token")
        )).join();

        final ImmutableList<CorporationWallet> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);
        final Optional<Double> mainWallet = list.stream()
            .filter(corporationWallet -> corporationWallet.getDivision() == 1)
            .map(CorporationWallet::getBalance)
            .findFirst()
            ;
        assertTrue(mainWallet.isPresent());
        assertTrue(mainWallet.get() > 0D);
    }
}