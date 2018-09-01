package gbsio.esiclient.api.domain.response.contracts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.universe.ItemType;
import gbsio.esiclient.internal.domain.response.contracts.DetailedContractItemImpl;

import java.util.Optional;

/**
 * Represents a contract item with more detail about singleton entities.
 */
@JsonDeserialize(as = DetailedContractItemImpl.class)
public interface DetailedContractItem {
    /**
     * Gets whether or not the a blueprint is a copy.
     * <p>
     * @return true if the blueprint is a copy, false if it is an original, and
     * empty if the item is not a blueprint
     */
    Optional<Boolean> isBlueprintCopy();

    /**
     * Gets the unique ID for the item.
     *
     * @return the item ID, or empty if {@link #isIncluded()} is false
     */
    Optional<Long> getItemID();

    /**
     * Gets the material efficiency of a blueprint item.
     *
     * @return a material efficiency between 0 and 25, or empty if the item is
     * not a blueprint
     */
    Optional<Integer> getMaterialEfficiency();

    /**
     * Gets the number of runs left on a blueprint item.
     *
     * @return the number of runs for a blueprint copy, -1 for an original
     * blueprint, or empty if the item is not a blueprint
     */
    Optional<Integer> getBlueprintRuns();

    /**
     * Gets the time efficiency of a blueprint item.
     *
     * @return a time efficiency between 0 and 20, or empty if the item is not a
     * blueprint
     */
    Optional<Integer> getTimeEfficiency();

    /**
     * Gets whether or not an item in the contract is being supplied or being requested.
     *
     * @return true if the item is being supplied, false if it is being requested.
     */
    boolean isIncluded();

    /**
     * Get the quantity of the item stack.
     *
     * @return the quantity
     */
    int getQuantity();

    /**
     * Gets the record ID for this item.
     * <p>
     * Record IDs are meaningful only to the contract itself, and ARE NOT the
     * same as an item ID.
     *
     * @return the record ID
     */
    long getRecordID();

    /**
     * Gets the ID for the item type.
     * <p>
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     *
     * @see ItemType
     */
    int getItemTypeID();
}
