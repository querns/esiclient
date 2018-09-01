package gbsio.esiclient.internal.domain.common.fitting;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.common.fittings.Item;

public class ItemImpl implements Item {
    private final int flag;
    private final int quantity;
    private final int itemTypeID;

    ItemImpl(
        @JsonProperty(value = "flag", required = true)
        final int flag,
        @JsonProperty(value = "quantity", required = true)
        final int quantity,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.flag = flag;
        this.quantity = quantity;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public int getFlag() {
        return flag;
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
