package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.RouteImpl;

/**
 * Represents the pathway taken by a Planetary Interaction product, traveling
 * over links, between pins.
 */
@JsonDeserialize(as = RouteImpl.class)
public interface Route {
    /**
     * Gets the ID of the item type being carried over this route.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID carried by this route
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getContentItemTypeID();

    /**
     * Gets the ID of the pin where the contents will be delivered.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the pin ID
     * @see Pin
     */
    long getDestinationPinID();

    /**
     * Gets the amount of product carried over this link.
     *
     * @return the quantity
     */
    float getQuantity();

    /**
     * Gets the unique ID for this route.
     *
     * @return the ID
     */
    long getID();

    /**
     * Gets the ID of the pin supplying the products traveling this route.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the source pin ID
     * @see Pin
     */
    long getSourcePinID();

    /**
     * Gets the IDs of the pins in between the source and destination pins.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 0 or more the intermediate pin IDs
     * @see Pin
     */
    ImmutableList<Long> getWaypoints();
}
