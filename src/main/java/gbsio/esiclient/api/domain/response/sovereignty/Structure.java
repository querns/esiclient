package gbsio.esiclient.api.domain.response.sovereignty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.sovereignty.StructureImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a structure responsible for holding sovereignty.
 */
@JsonDeserialize(as = StructureImpl.class)
public interface Structure {
    /**
     * Gets the ID of the alliance that owns this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    int getAllianceID();

    /**
     * Gets the ID of the solar system where this structure is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the unique item ID for this structure.
     *
     * @return the item ID
     */
    long getID();

    /**
     * Gets the item type ID for this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Gets the activity defense multiplier ("ADM") for this structure.
     *
     * ADMs are locked in when a structure exits vulnerability, and due to
     * active campaigns ending, may differ between structures in the same solar
     * system.
     *
     * @return the ADM
     */
    Optional<Float> getActivityDefenseMultiplier();

    /**
     * Gets the date that the structure becomes vulnerable for the day.
     *
     * @return the start date
     */
    Optional<ZonedDateTime> getVulnerableStartDate();

    /**
     * Gets the date that the structure stops being vulnerable for the day.
     *
     * @return the end date
     */
    Optional<ZonedDateTime> getVulnerableEndDate();
}
