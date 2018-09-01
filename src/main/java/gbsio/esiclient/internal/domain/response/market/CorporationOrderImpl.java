package gbsio.esiclient.internal.domain.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.market.CorporationOrder;
import gbsio.esiclient.api.domain.response.market.HistoricalOrderState;
import gbsio.esiclient.api.domain.response.market.OrderRange;

import java.time.ZonedDateTime;
import java.util.Optional;

public class CorporationOrderImpl implements CorporationOrder {
    private final Double escrow;
    private final Integer regionID;
    private final HistoricalOrderState state;
    private final int walletDivision;
    private final Integer issuerCharacterID;
    private final OrderImpl delegate;

    CorporationOrderImpl(
        @JsonProperty(value = "duration", required = true) final int duration,
        @JsonProperty("is_buy_order") final Boolean buyOrder,
        @JsonProperty(value = "issued", required = true) final ZonedDateTime issueDate,
        @JsonProperty(value = "location_id", required = true) final long locationID,
        @JsonProperty("min_volume") final Integer minVolume,
        @JsonProperty(value = "order_id", required = true) final long orderID,
        @JsonProperty(value = "price", required = true) final double price,
        @JsonProperty(value = "range", required = true) final OrderRange range,
        @JsonProperty(value = "type_id", required = true) final int itemTypeID,
        @JsonProperty(value = "volume_remain", required = true) final int remainingVolume,
        @JsonProperty(value = "volume_total", required = true) final int totalVolume,

        // CharacterOrder-specific parameters
        @JsonProperty("escrow") final Double escrow,
        @JsonProperty(value = "state") final HistoricalOrderState state,
        @JsonProperty(value = "region_id", required = true) final Integer regionID,
        @JsonProperty(value = "wallet_division", required = true) final int walletDivision,
        @JsonProperty("issued_by")
        final Integer issuerCharacterID) {
        this.delegate = new OrderImpl(duration, buyOrder, issueDate, locationID, minVolume, orderID, price, range, itemTypeID, remainingVolume, totalVolume);
        this.escrow = escrow;
        this.state = state;
        this.regionID = regionID;
        this.walletDivision = walletDivision;
        this.issuerCharacterID = issuerCharacterID;
    }

    @Override
    public Optional<Double> getEscrow() {
        return Optional.ofNullable(escrow);
    }

    @Override
    public Optional<Integer> getRegionID() {
        return Optional.ofNullable(regionID);
    }

    @Override
    public Optional<HistoricalOrderState> getState() {
        return Optional.ofNullable(state);
    }

    @Override
    public int getWalletDivision() {
        return walletDivision;
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

    @Override
    public Optional<Integer> getIssuerCharacterID() {
        return Optional.ofNullable(issuerCharacterID);
    }
}
