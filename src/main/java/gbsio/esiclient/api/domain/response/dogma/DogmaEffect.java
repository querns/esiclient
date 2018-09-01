package gbsio.esiclient.api.domain.response.dogma;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.dogma.DogmaEffectImpl;
import gbsio.esiclient.internal.domain.response.dogma.ModifierImpl;

import java.util.Optional;

/**
 * Represents a dogma effect. Dogma effects describe how modules and ships
 * impose effects on other modules and ships.
 *
 * @link http://eveonline-third-party-documentation.readthedocs.io/en/latest/dogma/intro.html
 */
@JsonDeserialize(as = DogmaEffectImpl.class)
public interface DogmaEffect {
    /**
     * Get the effect's description.
     *
     * @return the description
     */
    Optional<String> getDescription();

    /**
     * Gets whether the effect cannot be set to auto-repeat
     *
     * @return true if the effect cannot auto-repeat
     */
    Optional<Boolean> isAutoRepeatDisabled();

    /**
     * Get the ID of the attribute responsible for "discharge"
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the attribute ID
     * @see DogmaAttribute
     */
    Optional<Integer> getDischargeAttributeID();

    /**
     * Get the effect's display name
     *
     * @return the display name
     */
    Optional<String> getDisplayName();

    /**
     * Get the ID of the attribute responsible for determining this effect's
     * duration.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the attribute ID for the effect's duration.
     * @see DogmaAttribute
     */
    Optional<Integer> getDurationAttributeID();

    /**
     * Get the ID for the category of this effect.
     *
     * @return the category ID
     */
    Optional<Integer> getEffectCategoryID();

    /**
     * Get the unique ID for this effect.
     *
     * @return the ID
     */
    int getID();

    /**
     * Get whether the effect is related to electronic warfare.
     *
     * @return true if the effect is related to electronic warfare
     */
    Optional<Boolean> isElectronicChance();

    /**
     * Get the ID for the icon for this attribute.
     *
     * @return the icon ID
     */
    Optional<Integer> getIconID();

    /**
     * Gets whether the effect is considered to be remote assistance.
     *
     * @return true if the effect is remote assistance
     */
    Optional<Boolean> isAssistance();

    /**
     * Gets whether the effect is an offensive action.
     *
     * @return true if the effect is offensive
     */
    Optional<Boolean> isOffensive();

    /**
     * Gets whether the effect can apply while in warp.
     *
     * @return true if the effect can apply while in warp
     */
    Optional<Boolean> isWarpSafe();

    /**
     * Get the modifiers for this effect.
     *
     * @return 0 or more modifiers
     */
    ImmutableList<Modifier> getModifiers();

    /**
     * Get the name of this attribute.
     *
     * @return the name
     */
    Optional<String> getName();

    /**
     * Get the legacy preExpression ID.
     *
     * @return the preExpression
     */
    Optional<Integer> getPreExpression();

    /**
     * Get the legacy postExpression ID.
     *
     * @return the postExpression
     */
    Optional<Integer> getPostExpression();

    /**
     * Get whether the effect is published and available for use on TQ.
     *
     * @return true if the effect is published.
     */
    Optional<Boolean> isPublished();

    /**
     * Get the ID of the attribute that determines this effect's range.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the attribute ID that determines the effect's range
     * @see DogmaAttribute
     */
    Optional<Integer> getRangeAttributeID();

    /**
     * Get whether the effect is a "range chance."
     *
     * @return true if the effect is a "range change"
     */
    Optional<Boolean> isRangeChance();

    /**
     * Get the ID of attribute that determines this effect's tracking speed.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the attribute ID for determining tracking speed
     * @see DogmaAttribute
     */
    Optional<Integer> getTrackingSpeedAttributeID();

    /**
     * Represents how an effect modifies things.
     */
    @JsonDeserialize(as = ModifierImpl.class)
    interface Modifier {
        /**
         * Get the target of this modifier
         *
         * E.g.: a domain of "shipID" applies to one's own ship.
         *
         * @return the domain
         */
        Optional<String> getDomain();

        /**
         * Get the ID of the effect that this modifier applies to.
         *
         * @return the effect ID
         */
        Optional<Integer> getEffectID();

        /**
         * Get the type of modification occurring.
         *
         * @return the modification type
         */
        String getFunc();

        /**
         * Get the ID of the attribute that this modifier will effect.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the attribute ID of the modified attribute
         * @see DogmaAttribute
         */
        Optional<Integer> getModifiedAttributeID();

        /**
         * Get the ID of the attribute that is responsible for imposing the
         * effect.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the attribute ID modifying the effect
         */
        Optional<Integer> getModifyingAttributeID();

        /**
         * Get the ID of the operator used in this effect.
         *
         * @return the operator ID
         */
        Optional<Integer> getOperator();
    }
}
