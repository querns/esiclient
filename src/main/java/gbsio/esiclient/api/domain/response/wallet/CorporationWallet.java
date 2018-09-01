package gbsio.esiclient.api.domain.response.wallet;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.wallet.CorporationWalletImpl;

/**
 * Represents the wallet of a division of a corporation.
 */
@JsonDeserialize(as = CorporationWalletImpl.class)
public interface CorporationWallet {
    /**
     * Gets the balance for this wallet.
     *
     * @return the balance
     */
    double getBalance();

    /**
     * Gets the division number for this wallet.
     *
     * @return a division number between 1 and 7
     */
    int getDivision();
}
