package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.universe.ItemGroupImpl;

/**
 * Represent a group, containing item types.
 */
@JsonDeserialize(as = ItemGroupImpl.class)
public interface ItemGroup {
    /**
     * Gets the ID of the category containing this group.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the category ID
     * @see ItemCategory
     */
    int getCategoryID();

    /**
     * Gets the unique ID for this group.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the name of this group.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets whether this group is available on TQ.
     *
     * @return true if the group is published
     */
    boolean isPublished();

    /**
     * Gets a list of IDs of item types contained by this group.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 1 or more item type IDs
     */
    ImmutableList<Integer> getItemTypeIDs();
}
