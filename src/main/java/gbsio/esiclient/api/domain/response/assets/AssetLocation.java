package gbsio.esiclient.api.domain.response.assets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.Coordinates;
import gbsio.esiclient.internal.domain.response.assets.AssetLocationImpl;

/**
 * Represents the location of an asset.
 */
@JsonDeserialize(as=AssetLocationImpl.class)
public interface AssetLocation {
    /**
     * Gets the unique ID for this item.
     *
     * @return the item ID
     */
    long getItemID();

    /**
     * Gets the position for this item.
     *
     * An item in a hangar or station has a position of (0, 0, 0).
     *
     * @return the position
     */
    Coordinates getPosition();
}
