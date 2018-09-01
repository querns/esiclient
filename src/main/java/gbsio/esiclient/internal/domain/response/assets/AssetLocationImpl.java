package gbsio.esiclient.internal.domain.response.assets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.assets.AssetLocation;
import gbsio.esiclient.api.domain.response.common.Coordinates;

public class AssetLocationImpl implements AssetLocation {
    private final long itemID;
    private final Coordinates position;

    AssetLocationImpl(
        @JsonProperty(value="item_id", required = true)
        long itemID,
        @JsonProperty(value = "position", required = true)
            Coordinates position
    ) {
        this.itemID = itemID;
        this.position = position;
    }

    @Override
    public long getItemID() {
        return itemID;
    }

    @Override
    public Coordinates getPosition() {
        return position;
    }
}
