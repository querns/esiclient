package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaAttribute;
import gbsio.esiclient.api.domain.response.common.AssignedDogmaEffect;
import gbsio.esiclient.internal.domain.response.universe.ItemTypeImpl;

import java.util.Optional;

/**
 * Represents information about an item type.
 */
@JsonDeserialize(as = ItemTypeImpl.class)
public interface ItemType {
    /**
     * Returns the unique identifier integer for this item type.
     * @return the item's ID
     */
    int getID();

    /**
     * Returns the item's name.
     *
     * @return the name
     */
    String getName();

    /**
     * Returns the item's description.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Returns whether or not the item is published on TQ.
     *
     * @return the published status
     */
    boolean isPublished();

    /**
     * Returns the ID for the item group this item type belongs to.
     *
     * @return the item group ID
     * @see ItemGroup
     */
    int getGroupID();

    /**
     * Returns the item type's capacity in m^3. Usually used for items like
     * ships or ammo-consuming modules that need to hold other items.
     *
     * @return the capacity of the item type in cubic meters
     */
    Optional<Float> getCapacity();

    /**
     * Returns this type's dogma attributes. Only the attribute's ID and the
     * type's particular value for this attribute are returned; further
     * discovery will be required and is not in scope for this function call.
     *
     * @return A list of 0 or more of this type's dogma attributes
     * @see gbsio.esiclient.api.domain.response.dogma.DogmaAttribute
     */
    ImmutableList<AssignedDogmaAttribute> getDogmaAttributes();

    /**
     * Returns this type's dogma effects. Only the effect's ID and its "Is
     * Default" status is returned; further discovery will be required and is
     * not in scope for this function call.
     *
     * @return A list of 0 or more of this type's dogma effects
     * @see gbsio.esiclient.api.domain.response.dogma.DogmaEffect
     */
    ImmutableList<AssignedDogmaEffect> getDogmaEffects();

    /**
     * Get the graphic ID associated with this item type.
     *
     * @return the graphic ID
     */
    Optional<Integer> getGraphicID();

    /**
     * Get the icon ID associated with this item type.
     *
     * @return the icon ID
     */
    Optional<Integer> getIconID();

    /**
     * Get the market group ID associated with this item type. Only the market
     * group's ID will be returned; further discovery will be required and is
     * not in scope for this function call.
     *
     * @return the market group ID
     * @see gbsio.esiclient.api.domain.response.market.MarketGroup
     */
    Optional<Integer> getMarketGroupID();

    /**
     * Get the item type's mass.
     *
     * @return a mass in kilograms
     */
    Optional<Float> getMass();

    /**
     * Get the item's packaged volume. Usually used for items like ships and
     * modules, which can be carried in a smaller packaged form to aid
     * transport.
     *
     * @return the volume in cubic meters
     */
    Optional<Float> getPackagedVolume();

    /**
     * Get the item's portion size. Used by ores to determine how many items
     * are required for reprocessing.
     *
     * @return the portion size
     */
    Optional<Integer> getPortionSize();

    /**
     * Get the item's radius. Used for ships to determine their size.
     *
     * @return the radius in meters
     */
    Optional<Float> getRadius();

    /**
     * Get the item's volume. This is used to determine how much space the item
     * takes up in a container.
     *
     * @return the volume in cubic meters
     */
    Optional<Float> getVolume();
}
