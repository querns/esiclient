package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.market.OrderRange;
import gbsio.esiclient.api.domain.response.market.RegionalOrder;

import java.time.ZonedDateTime;
import java.util.Optional;

public class RegionalOrderImpl implements RegionalOrder {
    private final OrderImpl delegate;
    private final int solarSystemID;

    RegionalOrderImpl(
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

        // RegionalOrder-specific parameters
        @JsonProperty(value = "system_id", required = true)
        final int solarSystemID
    ) {
        this.delegate = new OrderImpl(duration, buyOrder, issueDate, locationID, minVolume, orderID, price, range, itemTypeID, remainingVolume, totalVolume);
        this.solarSystemID = solarSystemID;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    public int getDuration() {
        return delegate.getDuration();
    }

    public Optional<Boolean> isBuyOrder() {
        return delegate.isBuyOrder();
    }

    public ZonedDateTime getIssueDate() {
        return delegate.getIssueDate();
    }

    public long getLocationID() {
        return delegate.getLocationID();
    }

    public Optional<Integer> getMinVolume() {
        return delegate.getMinVolume();
    }

    public long getOrderID() {
        return delegate.getOrderID();
    }

    public double getPrice() {
        return delegate.getPrice();
    }

    public OrderRange getRange() {
        return delegate.getRange();
    }

    public int getItemTypeID() {
        return delegate.getItemTypeID();
    }

    public int getRemainingVolume() {
        return delegate.getRemainingVolume();
    }

    public int getTotalVolume() {
        return delegate.getTotalVolume();
    }
}
