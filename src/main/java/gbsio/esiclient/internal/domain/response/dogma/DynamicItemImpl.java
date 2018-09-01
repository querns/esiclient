package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;
import gbsio.esiclient.api.domain.response.dogma.DynamicItem;

public class DynamicItemImpl implements DynamicItem {
    private final int creatorCharacterID;
    private final ImmutableList<AssignedDogmaAttribute> dogmaAttributes;
    private final ImmutableList<AssignedDogmaEffect> dogmaEffects;
    private final int mutatorItemTypeID;
    private final int sourceItemTypeID;

    DynamicItemImpl(
        @JsonProperty(value = "created_by", required = true)
        final int creatorCharacterID,
        @JsonProperty(value = "dogma_attributes", required = true)
        final ImmutableList<AssignedDogmaAttribute> dogmaAttributes,
        @JsonProperty(value = "dogma_effects", required = true)
        final ImmutableList<AssignedDogmaEffect> dogmaEffects,
        @JsonProperty(value = "mutator_type_id", required = true)
        final int mutatorItemTypeID,
        @JsonProperty(value = "source_type_id", required = true)
        final int sourceItemTypeID
    ) {
        this.creatorCharacterID = creatorCharacterID;
        this.dogmaAttributes = dogmaAttributes;
        this.dogmaEffects = dogmaEffects;
        this.mutatorItemTypeID = mutatorItemTypeID;
        this.sourceItemTypeID = sourceItemTypeID;
    }

    @Override
    public int getCreatorCharacterID() {
        return creatorCharacterID;
    }

    @Override
    public ImmutableList<AssignedDogmaAttribute> getDogmaAttributes() {
        return dogmaAttributes;
    }

    @Override
    public ImmutableList<AssignedDogmaEffect> getDogmaEffects() {
        return dogmaEffects;
    }

    public int getMutatorItemTypeID() {
        return mutatorItemTypeID;
    }

    @Override
    public int getSourceItemTypeID() {
        return sourceItemTypeID;
    }
}
