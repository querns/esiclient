package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.Attributes;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.universe.BloodlineImpl;

/**
 * Represents a bloodline for characters and NPCs.
 */
@JsonDeserialize(as = BloodlineImpl.class)
public interface Bloodline extends Attributes {
    /**
     * Gets the unique ID for this bloodline.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the ID of the corporation associated with this bloodline.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Gets the description for this bloodline.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the name for this bloodline.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the ID of the race containing this bloodline.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the race ID
     * @see Race
     */
    int getRaceID();

    /**
     * Gets the ID of the item type of the signature ship of this bloodline.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ship's item type ID
     * @see ItemType
     */
    int getShipItemTypeID();
}
