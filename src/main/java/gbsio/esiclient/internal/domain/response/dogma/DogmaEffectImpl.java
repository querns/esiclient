package gbsio.esiclient.internal.domain.response.dogma;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.dogma.DogmaEffect;

import java.util.Optional;

public class DogmaEffectImpl implements DogmaEffect {
    private final String description;
    private final Boolean isAutoRepeatDisabled;
    private final Integer dischargeAttributeID;
    private final String displayName;
    private final Integer durationAttributeID;
    private final Integer effectCategoryID;
    private final int ID;
    private final Boolean isElectronicChance;
    private final Integer iconID;
    private final Boolean isAssistance;
    private final Boolean isOffensive;
    private final Boolean isWarpSafe;
    private final ImmutableList<Modifier> modifiers;
    private final String name;
    private final Integer preExpression;
    private final Integer postExpression;
    private final Boolean isPublished;
    private final Integer rangeAttributeID;
    private final Boolean isRangeChance;
    private final Integer trackingSpeedAttributeID;

    DogmaEffectImpl(
        @JsonProperty("description")
        final String description,
        @JsonProperty("disallow_auto_repeat")
        final Boolean isAutoRepeatDisabled,
        @JsonProperty("discharge_attribute_id")
        final Integer dischargeAttributeID,
        @JsonProperty("display_name")
        final String displayName,
        @JsonProperty("duration_attribute_id")
        final Integer durationAttributeID,
        @JsonProperty("effect_category")
        final Integer effectCategoryID,
        @JsonProperty(value = "effect_id", required = true)
        final int id,
        @JsonProperty("electronic_chance")
        final Boolean isElectronicChance,
        @JsonProperty("icon_id")
        final Integer iconID,
        @JsonProperty("is_assistance")
        final Boolean isAssistance,
        @JsonProperty("is_offensive")
        final Boolean isOffensive,
        @JsonProperty("is_warp_safe")
        final Boolean isWarpSafe,
        @JsonProperty("modifiers")
        final ImmutableList<Modifier> modifiers,
        @JsonProperty("name")
        final String name,
        @JsonProperty("pre_expression")
        final Integer preExpression,
        @JsonProperty("post_expression")
        final Integer postExpression,
        @JsonProperty("published")
        final Boolean isPublished,
        @JsonProperty("range_attribute_id")
        final Integer rangeAttributeID,
        @JsonProperty("range_chance")
        final Boolean isRangeChance,
        @JsonProperty("tracking_speed_attribute_id")
        final Integer trackingSpeedAttributeID
    ) {
        this.description = description;
        this.isAutoRepeatDisabled = isAutoRepeatDisabled;
        this.dischargeAttributeID = dischargeAttributeID;
        this.displayName = displayName;
        this.durationAttributeID = durationAttributeID;
        this.effectCategoryID = effectCategoryID;
        ID = id;
        this.isElectronicChance = isElectronicChance;
        this.iconID = iconID;
        this.isAssistance = isAssistance;
        this.isOffensive = isOffensive;
        this.isWarpSafe = isWarpSafe;
        this.modifiers = MoreObjects.firstNonNull(modifiers, ImmutableList.of());
        this.name = name;
        this.preExpression = preExpression;
        this.postExpression = postExpression;
        this.isPublished = isPublished;
        this.rangeAttributeID = rangeAttributeID;
        this.isRangeChance = isRangeChance;
        this.trackingSpeedAttributeID = trackingSpeedAttributeID;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<Boolean> isAutoRepeatDisabled() {
        return Optional.ofNullable(isAutoRepeatDisabled);
    }

    @Override
    public Optional<Integer> getDischargeAttributeID() {
        return Optional.ofNullable(dischargeAttributeID);
    }

    @Override
    public Optional<String> getDisplayName() {
        return Optional.ofNullable(displayName);
    }

    @Override
    public Optional<Integer> getDurationAttributeID() {
        return Optional.ofNullable(durationAttributeID);
    }

    public Optional<Integer> getEffectCategoryID() {
        return Optional.ofNullable(effectCategoryID);
    }

    @Override
    public int getID() {
        return ID;
    }

    public Optional<Boolean> isElectronicChance() {
        return Optional.ofNullable(isElectronicChance);
    }

    @Override
    public Optional<Integer> getIconID() {
        return Optional.ofNullable(iconID);
    }

    public Optional<Boolean> isAssistance() {
        return Optional.ofNullable(isAssistance);
    }

    public Optional<Boolean> isOffensive() {
        return Optional.ofNullable(isOffensive);
    }

    public Optional<Boolean> isWarpSafe() {
        return Optional.ofNullable(isWarpSafe);
    }

    @Override
    public ImmutableList<Modifier> getModifiers() {
        return modifiers;
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public Optional<Integer> getPreExpression() {
        return Optional.ofNullable(preExpression);
    }

    @Override
    public Optional<Integer> getPostExpression() {
        return Optional.ofNullable(postExpression);
    }

    public Optional<Boolean> isPublished() {
        return Optional.ofNullable(isPublished);
    }

    @Override
    public Optional<Integer> getRangeAttributeID() {
        return Optional.ofNullable(rangeAttributeID);
    }

    public Optional<Boolean> isRangeChance() {
        return Optional.ofNullable(isRangeChance);
    }

    @Override
    public Optional<Integer> getTrackingSpeedAttributeID() {
        return Optional.ofNullable(trackingSpeedAttributeID);
    }
}
