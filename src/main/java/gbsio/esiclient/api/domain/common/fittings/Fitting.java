package gbsio.esiclient.api.domain.common.fittings;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.google.common.collect.ImmutableList;

public interface Fitting {
    /**
     * Get the user-supplied description for this fitting.
     *
     * @return the description
     */
    @JsonGetter("description")
    String getDescription();

    /**
     * Get the items that are part of this fitting.
     *
     * @return the items
     */
    @JsonGetter("items")
    ImmutableList<Item> getItems();

    /**
     * Get the user-supplied name for this fitting.
     *
     * @return the name
     */
    @JsonGetter("name")
    String getName();

    /**
     * Get the item type ID for the ship used in this fitting.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID of the ship
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    @JsonGetter("ship_type_id")
    int getShipItemTypeID();
}
