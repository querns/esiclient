package gbsio.esiclient.internal.domain.response.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.wallet.CorporationWallet;

public class CorporationWalletImpl implements CorporationWallet {
    private final double balance;
    private final int division;

    CorporationWalletImpl(
        @JsonProperty(value = "balance", required = true)
        final double balance,
        @JsonProperty(value = "division", required = true)
        final int division
    ) {
        this.balance = balance;
        this.division = division;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public int getDivision() {
        return division;
    }
}
