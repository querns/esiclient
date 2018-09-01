package gbsio.esiclient.api.domain.response.killmails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.killmails.ItemImpl;

import java.util.Optional;

/**
 * Represents an item lost or dropped by the victim after the attack described
 * in a killmail.
 */
@JsonDeserialize(as = ItemImpl.class)
public interface Item {
    /**
     * Gets the inventory flag describing the location of this item.
     *
     * @return the inventory flag
     */
    int getFlag();

    /**
     * Gets the item type ID of this item
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Get the items that are contained inside this item, if any.
     *
     * @return 0 or more items
     */
    ImmutableList<Item> getContainedItems();

    /**
     * Get the quantity of items that were destroyed during the attack.
     *
     * @return the amount of destroyed items
     */
    Optional<Long> getQuantityDestroyed();

    /**
     * Get the quantity of items that were dropped during the attack.
     *
     * @return the amount of dropped items
     */
    Optional<Long> getQuantityDropped();

    /**
     * Get the magic singleton value, describing a blueprint.
     *
     * @return the magic singleton value
     */
    int getSingleton();
}
