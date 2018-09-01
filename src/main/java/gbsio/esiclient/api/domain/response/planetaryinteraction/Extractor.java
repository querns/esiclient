package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.ExtractorImpl;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.HeadImpl;

import java.util.Optional;

/**
 * Represents details about an extractor pin.
 */
@JsonDeserialize(as = ExtractorImpl.class)
public interface Extractor {
    /**
     * Gets the cycle time for this extractor.
     *
     * @return the cycle time in seconds
     */
    Optional<Integer> getCycleTime();

    /**
     * Gets the radius for this pin.
     *
     * @return the radius
     */
    Optional<Float> getHeadRadius();

    /**
     * Gets a list of extractor heads.
     *
     * @return 0 or more heads
     */
    ImmutableList<Head> getHeads();

    /**
     * Gets the ID of the item type being produced by this extractor.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the product's item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    Optional<Integer> getProductItemTypeID();

    /**
     * Gets the amount of product generated per cycle.
     *
     * @return the quantity per cycle
     */
    Optional<Integer> getQuantityPerCycle();


    /**
     * Represents an extractor head.
     *
     * Extractor heads are placed on the planet and use spherical harmonics data
     * from the planet to determine the extraction throughput.
     */
    @JsonDeserialize(as = HeadImpl.class)
    interface Head {
        /**
         * Gets the unique ID for this extractor head.
         *
         * @return the ID
         */
        int getID();

        /**
         * Gets the latitude and longitude for this extractor head.
         *
         * @return the lat/lon
         */
        LatLon getLatLon();
    }
}

