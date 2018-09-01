package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.market.CorporationOrderImpl;

import java.util.Optional;

/**
 * Represents privileged information for orders pulled at a corporate scope.
 */
@JsonDeserialize(as = CorporationOrderImpl.class)
public interface CorporationOrder extends Order {
    /**
     * Gets the amount of ISK in escrow for a buy order made with Margin
     * Trading.
     *
     * @return the escrow amount
     */
    Optional<Double> getEscrow();

    /**
     * Gets the reason why this order was completed.
     *
     * @return the completion reason
     */
    Optional<HistoricalOrderState> getState();

    /**
     * Gets the ID of the region where this order was placed.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the region ID
     * @see gbsio.esiclient.api.domain.response.universe.Region
     */
    Optional<Integer> getRegionID();

    /**
     * Gets the wallet division responsible for backing or receiving payment
     * from this order.
     *
     * @return a number between 1 and 7
     */
    int getWalletDivision();

    /**
     * Gets the ID of the character that issued this order.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the issuer character ID
     */
    Optional<Integer> getIssuerCharacterID();
}
