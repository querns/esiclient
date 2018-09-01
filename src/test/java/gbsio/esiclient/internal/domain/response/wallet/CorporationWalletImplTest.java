package gbsio.esiclient.internal.domain.response.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.wallet.CorporationWallet;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CorporationWalletImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<CorporationWallet> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/wallet/corporationWallet.json"),
            new TypeReference<ImmutableList<CorporationWallet>>() { }
        );

        assertEquals(1, list.size());
        CorporationWallet wallet = list.get(0);

        assertEquals(123.45D, wallet.getBalance());
        assertEquals(1, wallet.getDivision());
    }
}