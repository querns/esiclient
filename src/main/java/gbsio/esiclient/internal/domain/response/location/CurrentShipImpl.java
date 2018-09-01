package gbsio.esiclient.internal.domain.response.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.location.CurrentShip;

public class CurrentShipImpl implements CurrentShip {
    private final long itemID;
    private final String name;
    private final int itemTypeID;

    CurrentShipImpl(
        @JsonProperty(value = "ship_item_id", required = true)
        final long itemID,
        @JsonProperty(value = "ship_name", required = true)
        final String name,
        @JsonProperty(value = "ship_type_id", required = true)
        final int itemTypeID
    ) {
        this.itemID = itemID;
        this.name = name;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public long getItemID() {
        return itemID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
