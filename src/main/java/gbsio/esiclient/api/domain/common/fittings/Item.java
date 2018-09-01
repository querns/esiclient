package gbsio.esiclient.api.domain.common.fittings;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.common.fitting.ItemImpl;

/**
 * Represents an item fit or contained by a ship's fitting.
 */
@JsonDeserialize(as = ItemImpl.class)
public interface Item {
    /**
     * Get the flag value for the item on the fitting.
     *
     * These flag values can be resolved to a location on a ship using the
     * invFlags table in the SDE.
     *
     * @return the flag value
     */
    @JsonGetter("flag")
    int getFlag();

    /**
     * Get the quantity of this item in the current slot or cargo hold.
     *
     * @return the quantity
     */
    @JsonGetter("quantity")
    int getQuantity();

    /**
     * Get the item type ID of the fit or contained item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     */
    @JsonGetter("type_id")
    int getItemTypeID();
}
