package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.common.AssignedDogmaAttributeImpl;

/**
 * Represents a dogma attribute assigned to an item or item type.
 */
@JsonDeserialize(as = AssignedDogmaAttributeImpl.class)
public interface AssignedDogmaAttribute {
    /**
     * Gets the ID of the dogma attribute that is assigned to the item or item
     * type.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the attribute ID
     * @see gbsio.esiclient.api.domain.response.dogma.DogmaAttribute
     */
    int getAttributeID();

    /**
     * Gets the number to be used with this attribute.
     *
     * @return the number
     */
    float getNumber();

}
