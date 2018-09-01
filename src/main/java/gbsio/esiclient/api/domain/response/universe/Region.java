package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.universe.RegionImpl;

import java.util.Optional;

/**
 * Represents a region in New Eden.
 *
 * Regions contain constellations, which contain solar systems.
 */
@JsonDeserialize(as = RegionImpl.class)
public interface Region {
    /**
     * Gets the IDs of constellations contained by this region.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 1 or more constellation IDs
     */
    ImmutableList<Integer> getConstellationIDs();

    /**
     * Gets the description of this region.
     *
     * @return the description
     */
    Optional<String> getDescription();

    /**
     * Gets the name of the region.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the unique ID for this region.
     *
     * @return the ID
     */
    int getID();
}
