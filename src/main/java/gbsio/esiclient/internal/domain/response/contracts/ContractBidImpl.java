package gbsio.esiclient.internal.domain.response.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;

import java.time.ZonedDateTime;
import java.util.Optional;

public class ContractBidImpl implements ContractBid {
    private final float amount;
    private final int ID;
    private final Integer bidderID;
    private final ZonedDateTime date;

    ContractBidImpl(
        @JsonProperty(value = "amount", required = true)
        final float amount,
        @JsonProperty(value = "bid_id", required = true)
        final int id,
        @JsonProperty("bidder_id")
        final Integer bidderID,
        @JsonProperty(value = "date_bid", required = true)
        final ZonedDateTime date
    ) {
        this.amount = amount;
        ID = id;
        this.bidderID = bidderID;
        this.date = date;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Optional<Integer> getBidderID() {
        return Optional.ofNullable(bidderID);
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }
}
