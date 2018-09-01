package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.common.AssignedDogmaEffectImpl;

/**
 * Represents a dogma effect assigned to an item or item type.
 */
@JsonDeserialize(as = AssignedDogmaEffectImpl.class)
public interface AssignedDogmaEffect {
    /**
     * Gets the ID of the dogma effect to be applied to this item or item type.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the effect ID
     * @see gbsio.esiclient.api.domain.response.dogma.DogmaEffect
     */
    int getEffectID();

    /**
     * Gets whether the effect is on by default.
     *
     * @return true if the effect is on by default
     */
    boolean isDefault();
}
