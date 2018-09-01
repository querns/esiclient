package gbsio.esiclient.api.domain.response.common;

/**
 * Common methods for items in a hangar or ship.
 */
public interface ContainerItem {
    /**
     * Get the type ID for this item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return a type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Get the quantity of this item.
     *
     * @return the number of items in this stack. This quantity may be a
     * negative number. Negative numbers are magical; they indicate an
     * assembled/used blueprint. -1 refers to an original blueprint, and -2
     * refers to a blueprint copy.
     */
    int getQuantity();

    /**
     * Get the location ID for this item.
     *
     * @return the location ID
     */
    long getLocationID();

    /**
     * Get the item ID for this item.
     *
     * Item IDs differ from a {@link gbsio.esiclient.api.domain.response.universe.ItemType ItemType}
     * in that they uniquely describe an item or item stack. Multiple stacks of
     * the same item type will have differing item IDs.
     *
     * @return the item ID
     */
    long getItemID();

    /**
     * Get the location flag for this item.
     *
     * Location flags describe where on a ship or station hangar an item resides.
     * E.g.: a ship will contain a shield hardener fitted to it with a location
     * flag of "MedSlot0".
     *
     * @return the location flag
     */
    String getLocationFlag();
}
