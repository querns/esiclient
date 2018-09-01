package gbsio.esiclient.internal.domain.response.assets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.assets.Asset;
import gbsio.esiclient.api.domain.response.assets.LocationType;

import java.util.Optional;

public class AssetImpl implements Asset {
    private final long itemID;
    private final LocationType locationType;
    private final boolean isSingleton;
    private final int typeID;
    private final int quantity;
    private final long locationID;
    private final String locationFlag;
    private final Boolean isBlueprintCopy;

    AssetImpl(
        @JsonProperty(value = "item_id", required = true)
        long itemID,
        @JsonProperty(value = "location_type", required = true)
        String locationType,
        @JsonProperty(value = "is_singleton", required = true)
        boolean isSingleton,
        @JsonProperty(value = "type_id", required = true)
        int typeID,
        @JsonProperty(value = "quantity", required = true)
        int quantity,
        @JsonProperty(value = "location_id", required = true)
        long locationID,
        @JsonProperty(value = "location_flag", required = true)
        String locationFlag,
        @JsonProperty(value = "is_blueprint_copy")
        Boolean isBlueprintCopy
    ) {
        this.itemID = itemID;
        this.locationType = LocationType.of(locationType);
        this.isSingleton = isSingleton;
        this.typeID = typeID;
        this.quantity = quantity;
        this.locationID = locationID;
        this.locationFlag = locationFlag;
        this.isBlueprintCopy = isBlueprintCopy;
    }

    @Override
    public long getItemID() {
        return itemID;
    }

    @Override
    public LocationType getLocationType() {
        return locationType;
    }

    @Override
    public boolean isSingleton() {
        return isSingleton;
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

    @Override
    public Optional<Boolean> isBlueprintCopy() {
        return Optional.ofNullable(isBlueprintCopy);
    }
}
