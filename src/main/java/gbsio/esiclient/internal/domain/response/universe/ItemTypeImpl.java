package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;
import gbsio.esiclient.api.domain.response.universe.ItemType;

import java.util.Optional;

public class ItemTypeImpl implements ItemType {
    private final int ID;
    private final String name;
    private final String description;
    private final boolean published;
    private final int groupID;
    private final Float capacity;
    private final ImmutableList<AssignedDogmaAttribute> dogmaAttributes;
    private final ImmutableList<AssignedDogmaEffect> dogmaEffects;
    private final Integer graphicID;
    private final Integer iconID;
    private final Integer marketGroupID;
    private final Float mass;
    private final Float packagedVolume;
    private final Integer portionSize;
    private final Float radius;
    private final Float volume;

    ItemTypeImpl(
        @JsonProperty(value = "type_id", required = true)
        final int ID,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "published", required = true)
        final boolean published,
        @JsonProperty(value = "group_id", required = true)
        final int groupID,
        @JsonProperty("capacity")
        final Float capacity,
        @JsonProperty("dogma_attributes")
        final ImmutableList<AssignedDogmaAttribute> dogmaAttributes,
        @JsonProperty("dogma_effects")
        final ImmutableList<AssignedDogmaEffect> dogmaEffects,
        @JsonProperty("graphic_id")
        final Integer graphicID,
        @JsonProperty("icon_id")
        final Integer iconID,
        @JsonProperty("market_group_id")
        final Integer marketGroupID,
        @JsonProperty("mass")
        final Float mass,
        @JsonProperty("packaged_volume")
        final Float packagedVolume,
        @JsonProperty("portion_size")
        final Integer portionSize,
        @JsonProperty("radius")
        final Float radius,
        @JsonProperty("volume")
        final Float volume
    ) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.published = published;
        this.groupID = groupID;
        this.capacity = capacity;
        this.dogmaAttributes = MoreObjects.firstNonNull(dogmaAttributes, ImmutableList.of());
        this.dogmaEffects = MoreObjects.firstNonNull(dogmaEffects, ImmutableList.of());
        this.graphicID = graphicID;
        this.iconID = iconID;
        this.marketGroupID = marketGroupID;
        this.mass = mass;
        this.packagedVolume = packagedVolume;
        this.portionSize = portionSize;
        this.radius = radius;
        this.volume = volume;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isPublished() {
        return published;
    }

    @Override
    public int getGroupID() {
        return groupID;
    }

    @Override
    public Optional<Float> getCapacity() {
        return Optional.ofNullable(capacity);
    }

    @Override
    public ImmutableList<AssignedDogmaAttribute> getDogmaAttributes() {
        return dogmaAttributes;
    }

    @Override
    public ImmutableList<AssignedDogmaEffect> getDogmaEffects() {
        return dogmaEffects;
    }

    @Override
    public Optional<Integer> getGraphicID() {
        return Optional.ofNullable(graphicID);
    }

    @Override
    public Optional<Integer> getIconID() {
        return Optional.ofNullable(iconID);
    }

    @Override
    public Optional<Integer> getMarketGroupID() {
        return Optional.ofNullable(marketGroupID);
    }

    @Override
    public Optional<Float> getMass() {
        return Optional.ofNullable(mass);
    }

    @Override
    public Optional<Float> getPackagedVolume() {
        return Optional.ofNullable(packagedVolume);
    }

    @Override
    public Optional<Integer> getPortionSize() {
        return Optional.ofNullable(portionSize);
    }

    @Override
    public Optional<Float> getRadius() {
        return Optional.ofNullable(radius);
    }

    @Override
    public Optional<Float> getVolume() {
        return Optional.ofNullable(volume);
    }
}
