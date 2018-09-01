package gbsio.esiclient.internal.domain.response.loyalty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyStoreOffer;

import java.util.Optional;

public class LoyaltyStoreOfferImpl implements LoyaltyStoreOffer {
    private final Integer AnalysisKreditCost;
    private final long iskCost;
    private final int loyaltyPointCost;
    private final int ID;
    private final int quantity;
    private final ImmutableList<RequiredItem> requiredItems;
    private final int itemTypeID;

    LoyaltyStoreOfferImpl(
        @JsonProperty("ak_cost")
        final Integer analysisKreditCost,
        @JsonProperty(value = "isk_cost", required = true)
        final long iskCost,
        @JsonProperty(value = "lp_cost", required = true)
        final int loyaltyPointCost,
        @JsonProperty(value = "offer_id", required = true)
        final int id,
        @JsonProperty(value = "quantity", required = true)
        final int quantity,
        @JsonProperty(value = "required_items", required = true)
        final ImmutableList<RequiredItem> requiredItems,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        AnalysisKreditCost = analysisKreditCost;
        this.iskCost = iskCost;
        this.loyaltyPointCost = loyaltyPointCost;
        ID = id;
        this.quantity = quantity;
        this.requiredItems = MoreObjects.firstNonNull(requiredItems, ImmutableList.of());
        this.itemTypeID = itemTypeID;
    }

    @Override
    public Optional<Integer> getAnalysisKreditCost() {
        return Optional.ofNullable(AnalysisKreditCost);
    }

    public long getISKCost() {
        return iskCost;
    }

    @Override
    public int getLoyaltyPointCost() {
        return loyaltyPointCost;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public ImmutableList<RequiredItem> getRequiredItems() {
        return requiredItems;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
