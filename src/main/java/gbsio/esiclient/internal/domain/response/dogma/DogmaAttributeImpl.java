package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.dogma.DogmaAttribute;

import java.util.Optional;

public class DogmaAttributeImpl implements DogmaAttribute {
    private final int id;
    private final Float defaultValue;
    private final String description;
    private final String displayName;
    private final Boolean isHighGood;
    private final Integer iconID;
    private final String name;
    private final Boolean isPublished;
    private final Boolean isStackable;
    private final Integer unitID;

    DogmaAttributeImpl(
        @JsonProperty(value = "attribute_id", required = true) final int id,
        @JsonProperty("default_value") final Float defaultValue,
        @JsonProperty("description") final String description,
        @JsonProperty("display_name") final String displayName,
        @JsonProperty("high_is_good") final Boolean isHighGood,
        @JsonProperty("icon_id") final Integer iconID,
        @JsonProperty("name") final String name,
        @JsonProperty("published") final Boolean isPublished,
        @JsonProperty("stackable") final Boolean isStackable,
        @JsonProperty("unit_id") final Integer unitID
    ) {
        this.id = id;
        this.defaultValue = defaultValue;
        this.description = description;
        this.displayName = displayName;
        this.isHighGood = isHighGood;
        this.iconID = iconID;
        this.name = name;
        this.isPublished = isPublished;
        this.isStackable = isStackable;
        this.unitID = unitID;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Optional<Float> getDefaultValue() {
        return Optional.ofNullable(defaultValue);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public Optional<String> getDisplayName() {
        return Optional.ofNullable(displayName);
    }

    @Override
    public Optional<Boolean> isHighGood() {
        return Optional.ofNullable(isHighGood);
    }

    @Override
    public Optional<Integer> getIconID() {
        return Optional.ofNullable(iconID);
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public Optional<Boolean> isPublished() {
        return Optional.ofNullable(isPublished);
    }

    @Override
    public Optional<Boolean> isStackable() {
        return Optional.ofNullable(isStackable);
    }

    @Override
    public Optional<Integer> getUnitID() {
        return Optional.ofNullable(unitID);
    }
}
