package gbsio.esiclient.api.domain.response.dogma;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;
import gbsio.esiclient.internal.domain.response.dogma.DynamicItemImpl;

/**
 * Represents unique information for an item that has been mutated by a mutaplasmid.
 */
@JsonDeserialize(as = DynamicItemImpl.class)
public interface DynamicItem {
    /**
     * Gets the ID of the character that created this dynamic item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the creator's character ID
     * @see gbsio.esiclient.api.domain.response.character.CharacterInfo
     */
    int getCreatorCharacterID();

    /**
     * Gets the dogma attributes so mutated for this item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 1 or more dogma attributes
     * @see DogmaAttribute
     */
    ImmutableList<AssignedDogmaAttribute> getDogmaAttributes();

    /**
     * Gets the dogma effects so mutated for this item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return 1 or more dogma effects
     * @see DogmaEffect
     */
    ImmutableList<AssignedDogmaEffect> getDogmaEffects();

    /**
     * Gets the ID of the item type of mutator used to create this item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID of the mutator
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getMutatorItemTypeID();

    /**
     * Gets the ID of the item type of the source item used to create this item.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID of the source item
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getSourceItemTypeID();
}
