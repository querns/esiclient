package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.market.HistoricalOrderState;
import gbsio.esiclient.api.domain.response.market.OrderRange;
import gbsio.esiclient.api.domain.response.market.CharacterOrder;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CharacterOrderImpl implements CharacterOrder {
    private final Double escrow;
    private final Boolean isCorporateOrder;
    private final Integer regionID;
    private final HistoricalOrderState state;
    private final OrderImpl delegate;

    CharacterOrderImpl(
        // Common parameters
        @JsonProperty(value = "duration", required = true)
        final int duration,
        @JsonProperty("is_buy_order")
        final Boolean buyOrder,
        @JsonProperty(value = "issued", required = true)
        final ZonedDateTime issueDate,
        @JsonProperty(value = "location_id", required = true)
        final long locationID,
        @JsonProperty("min_volume")
        final Integer minVolume,
        @JsonProperty(value = "order_id", required = true)
        final long orderID,
        @JsonProperty(value = "price", required = true)
        final double price,
        @JsonProperty(value = "range", required = true)
        final OrderRange range,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID,
        @JsonProperty(value = "volume_remain", required = true)
        final int remainingVolume,
        @JsonProperty(value = "volume_total", required = true)
        final int totalVolume,

        // CharacterOrder-specific parameters
        @JsonProperty("escrow")
        final Double escrow,
        @JsonProperty(value = "state")
        final HistoricalOrderState state,
        @JsonProperty(value = "is_corporation", required = true)
        final Boolean isCorporateOrder,
        @JsonProperty(value = "region_id", required = true)
        final Integer regionID
    ) {
        this.delegate = new OrderImpl(duration, buyOrder, issueDate, locationID, minVolume, orderID, price, range, itemTypeID, remainingVolume, totalVolume);
        this.escrow = escrow;
        this.state = state;
        this.isCorporateOrder = isCorporateOrder;
        this.regionID = regionID;
    }

    @Override
    public Optional<Double> getEscrow() {
        return Optional.ofNullable(escrow);
    }

    @Override
    public Optional<HistoricalOrderState> getState() {
        return Optional.ofNullable(state);
    }

    public Optional<Boolean> isCorporateOrder() {
        return Optional.ofNullable(isCorporateOrder);
    }

    @Override
    public Optional<Integer> getRegionID() {
        return Optional.ofNullable(regionID);
    }

    @Override
    public int getDuration() {
        return delegate.getDuration();
    }

    @Override
    public Optional<Boolean> isBuyOrder() {
        return delegate.isBuyOrder();
    }

    @Override
    public ZonedDateTime getIssueDate() {
        return delegate.getIssueDate();
    }

    @Override
    public long getLocationID() {
        return delegate.getLocationID();
    }

    @Override
    public Optional<Integer> getMinVolume() {
        return delegate.getMinVolume();
    }

    @Override
    public long getOrderID() {
        return delegate.getOrderID();
    }

    @Override
    public double getPrice() {
        return delegate.getPrice();
    }

    @Override
    public OrderRange getRange() {
        return delegate.getRange();
    }

    @Override
    public int getItemTypeID() {
        return delegate.getItemTypeID();
    }

    @Override
    public int getRemainingVolume() {
        return delegate.getRemainingVolume();
    }

    @Override
    public int getTotalVolume() {
        return delegate.getTotalVolume();
    }
}
