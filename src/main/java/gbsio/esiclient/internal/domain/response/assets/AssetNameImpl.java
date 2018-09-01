package gbsio.esiclient.internal.domain.response.assets;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.assets.AssetName;

public class AssetNameImpl implements AssetName {
    private final long itemID;
    private final String name;

    AssetNameImpl(
        @JsonProperty(value="item_id", required=true)
        long itemID,
        @JsonProperty(value="name", required=true)
        String name
    ) {
        this.itemID = itemID;
        this.name = name;
    }

    @Override
    public long getItemID() {
        return itemID;
    }

    @Override
    public String getName() {
        return name;
    }
}
