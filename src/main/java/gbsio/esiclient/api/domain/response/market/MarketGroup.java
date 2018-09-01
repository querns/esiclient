package gbsio.esiclient.api.domain.response.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.market.MarketGroupImpl;

import java.util.Optional;

/**
 * Represents information about a market group.
 */
@JsonDeserialize(as = MarketGroupImpl.class)
public interface MarketGroup {
    /**
     * Gets the description for this market group.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the unique ID for this market group.
     *
     * @return the market group ID
     */
    int getID();

    /**
     * Gets the name for this market group.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the ID of the parent market group, if any.
     *
     * @return the parent market group ID
     */
    Optional<Integer> getParentID();

    /**
     * Gets the IDs of the market types associated with this market group.
     *
     * Only the IDs are returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type IDs in this market group
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    ImmutableList<Integer> getItemTypeIDs();
}
