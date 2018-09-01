package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Blueprint;

public class BlueprintImpl implements Blueprint {
    private final long itemID;
    private final int materialEfficiency;
    private final int timeEfficiency;
    private final int runs;
    private final int typeID;
    private final int quantity;
    private final long locationID;
    private final String locationFlag;

    BlueprintImpl(
        @JsonProperty(value = "item_id", required = true)
        final long itemID,
        @JsonProperty(value = "material_efficiency", required = true)
        final int materialEfficiency,
        @JsonProperty(value = "time_efficiency", required = true)
        final int timeEfficiency,
        @JsonProperty(value = "runs", required = true)
        final int runs,
        @JsonProperty(value = "type_id", required = true)
        final int typeID,
        @JsonProperty(value = "quantity", required = true)
        final int quantity,
        @JsonProperty(value = "location_id", required = true)
        final long locationID,
        @JsonProperty(value = "location_flag", required = true)
        final String locationFlag
    ) {
        this.itemID = itemID;
        this.materialEfficiency = materialEfficiency;
        this.timeEfficiency = timeEfficiency;
        this.runs = runs;
        this.typeID = typeID;
        this.quantity = quantity;
        this.locationID = locationID;
        this.locationFlag = locationFlag;
    }

    public long getItemID() {
        return itemID;
    }

    @Override
    public int getMaterialEfficiency() {
        return materialEfficiency;
    }

    @Override
    public int getTimeEfficiency() {
        return timeEfficiency;
    }

    @Override
    public int getRuns() {
        return runs;
    }

    @Override
    public int getItemTypeID() {
        return typeID;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public long getLocationID() {
        return locationID;
    }

    @Override
    public String getLocationFlag() {
        return locationFlag;
    }
}
