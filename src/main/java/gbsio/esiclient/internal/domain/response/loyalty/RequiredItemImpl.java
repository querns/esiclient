package gbsio.esiclient.internal.domain.response.loyalty;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.loyalty.LoyaltyStoreOffer;

public class RequiredItemImpl implements LoyaltyStoreOffer.RequiredItem {
    private final int quantity;
    private final int itemTypeID;

    RequiredItemImpl(
        @JsonProperty(value = "quantity", required = true)
        final int quantity,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.quantity = quantity;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
