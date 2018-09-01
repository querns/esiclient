package gbsio.esiclient.api.domain.response.dogma;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.dogma.DogmaAttributeImpl;

import java.util.Optional;

/**
 * Represents a dogma attribute. These attributes describe item types and are
 * used to differentiate between different modules of the same group.
 *
 * E.g.: a shield hardener will store the amount by which it raises a ship's
 * resists in a dogma attribute.
 */
@JsonDeserialize(as = DogmaAttributeImpl.class)
public interface DogmaAttribute {
    /**
     * Get the uniquely identifying ID for this attribute.
     *
     * @return the ID
     */
    int getID();

    /**
     * Get the default value for this attribute.
     *
     * @return the default value
     */
    Optional<Float> getDefaultValue();

    /**
     * Get the attribute's description.
     *
     * @return the description
     */
    Optional<String> getDescription();

    /**
     * Get the display name for this attribute.
     *
     * @return the display name
     */
    Optional<String> getDisplayName();

    /**
     * Get whether a high value is considered beneficial for this attribute.
     *
     * @return true if high is good, false if low is good`
     */
    Optional<Boolean> isHighGood();

    /**
     * Get the icon ID for this attribute.
     *
     * @return the icon ID
     */
    Optional<Integer> getIconID();

    /**
     * Get the attribute's name.
     *
     * @return the name
     */
    Optional<String> getName();

    /**
     * Get whether the attribute is published and available for use by players.
     *
     * @return true if the attribute is published
     */
    Optional<Boolean> isPublished();

    /**
     * Get whether the attribute suffers from the <a href="https://wiki.eveuniversity.org/Stacking_penalties">stacking penalty</a>.
     *
     * @return true if the attribute has a stacking penalty
     */
    Optional<Boolean> isStackable();

    /**
     * Get the unit ID for this attribute.
     *
     * Units are not currently exposed via ESI, and must be referenced from the
     * Static Data Export.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the unit ID
     */
    Optional<Integer> getUnitID();
}
