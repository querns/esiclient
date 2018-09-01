package gbsio.esiclient.api.domain.response.assets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.assets.AssetNameImpl;

/**
 * Represents the name of an asset.
 */
@JsonDeserialize(as=AssetNameImpl.class)
public interface AssetName {
    /**
     * Gets the unique ID associated with the asset.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ID
     */
    long getItemID();

    /**
     * Gets the name associated with this asset.
     *
     * @return the name
     */
    String getName();
}
