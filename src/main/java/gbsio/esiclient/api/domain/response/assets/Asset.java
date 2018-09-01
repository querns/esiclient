package gbsio.esiclient.api.domain.response.assets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.ContainerItem;
import gbsio.esiclient.internal.domain.response.assets.AssetImpl;

import java.util.Optional;

/**
 * Represents an asset belonging to a character or corporation.
 */
@JsonDeserialize(as = AssetImpl.class)
public interface Asset extends ContainerItem {
    /**
     * Get the type of location describing where this asset is located.
     *
     * @return a location type
     */
    LocationType getLocationType();

    /**
     * Gets the singleton status for this asset.
     *
     * Items that can be "assembled" (such as ships, blueprints, or modules)
     * that can no longer be stacked are considered singletons.
     *
     * @return whether or not the asset is a singleton
     */
    boolean isSingleton();

    /**
     * Gets whether or not a blueprint asset is a copy.
     *
     * @return true if the blueprint is a copy, false if it's an original, or
     * missing if the asset isn't a blueprint
     */
    Optional<Boolean> isBlueprintCopy();
}
