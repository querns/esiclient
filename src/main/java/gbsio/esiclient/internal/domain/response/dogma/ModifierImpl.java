package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.dogma.DogmaEffect;

import java.util.Optional;

public class ModifierImpl implements DogmaEffect.Modifier {
    private final String domain;
    private final Integer effectID;
    private final String func;
    private final Integer modifiedAttributeID;
    private final Integer modifyingAttributeID;
    private final Integer operator;

    ModifierImpl(
        @JsonProperty("domain")
        final String domain,
        @JsonProperty("effect_id")
        final Integer effectID,
        @JsonProperty(value = "func", required = true)
        final String func,
        @JsonProperty("modified_attribute_id")
        final Integer modifiedAttributeID,
        @JsonProperty("modifying_attribute_id")
        final Integer modifyingAttributeID,
        @JsonProperty("operator")
        final Integer operator
    ) {
        this.domain = domain;
        this.effectID = effectID;
        this.func = func;
        this.modifiedAttributeID = modifiedAttributeID;
        this.modifyingAttributeID = modifyingAttributeID;
        this.operator = operator;
    }

    @Override
    public Optional<String> getDomain() {
        return Optional.ofNullable(domain);
    }

    @Override
    public Optional<Integer> getEffectID() {
        return Optional.ofNullable(effectID);
    }

    @Override
    public String getFunc() {
        return func;
    }

    @Override
    public Optional<Integer> getModifiedAttributeID() {
        return Optional.ofNullable(modifiedAttributeID);
    }

    @Override
    public Optional<Integer> getModifyingAttributeID() {
        return Optional.ofNullable(modifyingAttributeID);
    }

    @Override
    public Optional<Integer> getOperator() {
        return Optional.ofNullable(operator);
    }
}
