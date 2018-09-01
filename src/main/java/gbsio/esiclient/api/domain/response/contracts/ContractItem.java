package gbsio.esiclient.api.domain.response.contracts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.contracts.ContractItemImpl;

import java.util.Optional;

/**
 * Represents an item associated with a contract.
 */
@JsonDeserialize(as = ContractItemImpl.class)
public interface ContractItem {
    /**
     * Gets whether or not an item in the contract is being supplied or being
     * requested.
     *
     * @return true if the item is being supplied, false if it is being
     * requested.
     */
    boolean isIncluded();

    /**
     * Gets whether or not the item is assembled.
     *
     * @return true if the item is assembled
     */
    boolean isSingleton();

    /**
     * Get the quantity of the item stack.
     *
     * @return the quantity
     */
    int getQuantity();

    /**
     * Gets the raw quantity of the item.
     *
     * This value is magical; -1 indicates a singleton. If the item is a
     * blueprint, -1 indicates an original blueprint and -2 indicates a copy.
     *
     * @return the magical value
     */
    Optional<Integer> getRawQuantity();

    /**
     * Gets the record ID for this item.
     *
     * Record IDs are meaningful only to the contract itself, and ARE NOT the
     * same as an item ID.
     *
     * @return the record ID
     */
    long getRecordID();

    /**
     * Gets the ID for the item type.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();
}
