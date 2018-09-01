package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.market.AdjustedPriceData;

import java.util.Optional;

public class AdjustedPriceDataImpl implements AdjustedPriceData {
    private final Double adjustedPrice;
    private final Double averagePrice;
    private final int itemTypeID;

    AdjustedPriceDataImpl(
        @JsonProperty("adjusted_price")
        final Double adjustedPrice,
        @JsonProperty("average_price")
        final Double averagePrice,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.adjustedPrice = adjustedPrice;
        this.averagePrice = averagePrice;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public Optional<Double> getAdjustedPrice() {
        return Optional.ofNullable(adjustedPrice);
    }

    @Override
    public Optional<Double> getAveragePrice() {
        return Optional.ofNullable(averagePrice);
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
