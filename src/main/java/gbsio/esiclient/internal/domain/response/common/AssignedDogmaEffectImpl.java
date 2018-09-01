package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;

public class AssignedDogmaEffectImpl implements AssignedDogmaEffect {
    private final int effectID;
    private final boolean isDefault;

    public AssignedDogmaEffectImpl(
        @JsonProperty(value = "effect_id", required = true)
        final int effectID,
        @JsonProperty(value = "is_default", required = true)
        final boolean isDefault
    ) {
        this.effectID = effectID;
        this.isDefault = isDefault;
    }

    @Override
    public int getEffectID() {
        return effectID;
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }
}
