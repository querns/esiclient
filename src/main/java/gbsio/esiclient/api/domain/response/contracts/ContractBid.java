package gbsio.esiclient.api.domain.response.contracts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.contracts.ContractBidImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a bid on a contract.
 */
@JsonDeserialize(as = ContractBidImpl.class)
public interface ContractBid {
    /**
     * Gets the amount of the bid.
     *
     * @return the amount in ISK
     */
    float getAmount();

    /**
     * Gets the unique ID associated with this bid.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the character ID of the bidder.
     *
     * This information is absent for bids on public contracts.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the bidder's character ID
     */
    Optional<Integer> getBidderID();

    /**
     * Gets the date and time the bid was made.
     * @return the date
     */
    ZonedDateTime getDate();
}
