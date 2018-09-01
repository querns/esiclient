package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.universe.ItemCategoryImpl;

/**
 * Represents a category of item groups.
 */
@JsonDeserialize(as = ItemCategoryImpl.class)
public interface ItemCategory {
    /**
     * Gets the unique ID for this category.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the IDs of groups contained by this category.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 1 or more group IDs
     * @see ItemGroup
     */
    ImmutableList<Integer> getGroupIDs();

    /**
     * Gets the name of this category.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets whether or not this category is available on TQ.
     *
     * @return true if the category is published
     */
    boolean isPublished();
}
