package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.market.Order;
import gbsio.esiclient.api.domain.response.market.OrderRange;

import java.time.ZonedDateTime;
import java.util.Optional;

public class OrderImpl implements Order {
    private final int duration;
    private final Boolean buyOrder;
    private final ZonedDateTime issueDate;
    private final long locationID;
    private final Integer minVolume;
    private final long orderID;
    private final double price;
    private final OrderRange range;
    private final int itemTypeID;
    private final int remainingVolume;
    private final int totalVolume;

    OrderImpl(
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
        final int totalVolume
    ) {
        this.minVolume = minVolume;
        this.buyOrder = buyOrder;
        this.issueDate = issueDate;
        this.duration = duration;
        this.price = price;
        this.range = range;
        this.remainingVolume = remainingVolume;
        this.orderID = orderID;
        this.locationID = locationID;
        this.totalVolume = totalVolume;
        this.itemTypeID = itemTypeID;
    }

    public int getDuration() {
        return duration;
    }

    public Optional<Boolean> isBuyOrder() {
        return Optional.ofNullable(buyOrder);
    }

    public ZonedDateTime getIssueDate() {
        return issueDate;
    }

    public long getLocationID() {
        return locationID;
    }

    public Optional<Integer> getMinVolume() {
        return Optional.ofNullable(minVolume);
    }

    public long getOrderID() {
        return orderID;
    }

    public double getPrice() {
        return price;
    }

    public OrderRange getRange() {
        return range;
    }

    public int getItemTypeID() {
        return itemTypeID;
    }

    public int getRemainingVolume() {
        return remainingVolume;
    }

    public int getTotalVolume() {
        return totalVolume;
    }
}
