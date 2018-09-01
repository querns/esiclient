package gbsio.esiclient.api.domain.response.location;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.location.CurrentShipImpl;

/**
 * Represents the ship that the character is flying at the time of the API call.
 */
@JsonDeserialize(as = CurrentShipImpl.class)
public interface CurrentShip {
    /**
     * Gets the unique ID for this ship.
     *
     * @return the item ID
     */
    long getItemID();

    /**
     * Gets the user-supplied name of the ship.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the item type ID of the ship.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();
}
