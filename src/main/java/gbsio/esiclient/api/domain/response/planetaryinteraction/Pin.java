package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.ContainedItemImpl;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.PinImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a building on a Planetary Interaction colony.
 */
@JsonDeserialize(as = PinImpl.class)
public interface Pin {
    /**
     * Gets the contents of a pin.
     *
     * Relevant for command centers, silos, and launchpads.
     *
     * @return 0 or more contained items
     */
    ImmutableList<ContainedItem> getContents();

    /**
     * Gets the date that an extractor finishes its cycle.
     *
     * Only relevant for extractors.
     *
     * @return the extractor expiry date
     */
    Optional<ZonedDateTime> getExpiryDate();

    /**
     * Gets mechanical details about an extractor pin.
     *
     * Only relevant for extractors.
     *
     * @return the extractor details
     */
    Optional<Extractor> getExtractorDetails();

    /**
     * Gets the ID for the schematic installed in a factory.
     *
     * Only relevant for factory pins.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the schematic ID installed in a factory
     * @see Schematic
     */
    Optional<Integer> getFactorySchematicID();

    /**
     * Gets the date that this pin was added to the colony.
     *
     * @return the install date
     */
    Optional<ZonedDateTime> getInstallDate();

    /**
     * Gets the date that an extractor started its cycle.
     *
     * Only relevant for extractors.
     *
     * @return the extractor cycle start date
     */
    Optional<ZonedDateTime> getLastCycleStartDate();

    /**
     * Gets the latitude and longitude for this pin.
     *
     * @return the lat/lon
     */
    LatLon getLatLon();

    /**
     * Gets the unique ID for this pin.
     *
     * @return the ID
     */
    long getID();

    /**
     * Gets the schematic ID for this pin.
     *
     * @return the schematic ID
     */
    Optional<Integer> getSchematicID();

    /**
     * Gets the item type ID for this pin.
     *
     * Pin types are described as item types in the database.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Represents an item contained by a pin.
     */
    @JsonDeserialize(as = ContainedItemImpl.class)
    interface ContainedItem {
        /**
         * Gets the amount of this item present.
         *
         * @return the amount
         */
        long getAmount();

        /**
         * Gets the ID of the item type for this item.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the item type ID
         * @see gbsio.esiclient.api.domain.response.universe.ItemType
         */
        int getItemTypeID();
    }
}
