package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Pin;

public class ContainedItemImpl implements Pin.ContainedItem {
    private final long amount;
    private final int itemTypeID;

    ContainedItemImpl(
        @JsonProperty(value = "amount", required = true)
        final long amount,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.amount = amount;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
