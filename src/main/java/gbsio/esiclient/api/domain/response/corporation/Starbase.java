package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.corporations.StarbaseImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents shallow information about a Player Owned Starbase (POS).
 */
@JsonDeserialize(as = StarbaseImpl.class)
public interface Starbase {
    /**
     * Gets the item ID of the moon this starbase orbits.
     *
     * Will be missing for unanchored starbases.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item ID of the moon
     * @see gbsio.esiclient.api.domain.response.universe.Moon
     */
    Optional<Integer> getMoonID();

    /**
     * Gets the date the starbase last transitioned into the "Online" state.
     *
     * Only applicable to starbases that are {@link StarbaseState#ONLINE online}.
     *
     * @return the online date
     */
    Optional<ZonedDateTime> getOnlinedSince();

    /**
     * Gets the date that the starbase exits reinforced mode.
     *
     * Only applicable for starbases that are {@link StarbaseState#REINFORCED reinforced.}
     *
     * @return the date the starbase exits reinforced mode
     */
    Optional<ZonedDateTime> getReinforcedUntil();

    /**
     * Gets the unique item ID for this starbase.
     *
     * @return the starbase ID
     * @see StarbaseDetail
     */
    long getStarbaseID();

    /**
     * Gets the operating state of the starbase.
     *
     * Missing if the structure is completely unanchored.
     *
     * @return the starbase state
     */
    Optional<StarbaseState> getState();

    /**
     * Gets the solar system ID where the starbase is located.
     *
     * Guaranteed to be present, even if the starbase is completely unanchored
     * (and thus missing its {@link #getMoonID() moon ID}.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     */
    int getSolarSystemID();

    /**
     * Gets the item type ID of this starbase.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Gets the date that the starbase finishes unanchoring.
     *
     * Only applicable for starbases that are {@link StarbaseState#UNANCHORING unanchoring}.
     *
     * @return the unanchor date
     */
    Optional<ZonedDateTime> getUnanchorAt();

    /**
     * Describes the operational state of a starbase.
     */
    enum StarbaseState implements EnumUtil.MappableEnum {
        /**
         * A starbase that has finished anchoring, but has no force field and is
         * not consuming fuel.
         *
         * Starbases can fall into this state from the {@link #ONLINE online}
         * state if they run out of fuel.
         */
        OFFLINE("offline"),

        /**
         * A starbase that is fueled and whose force field is operational.
         */
        ONLINE("online"),

        /**
         * A starbase that has finished anchoring and is currently spooling up
         * its force field.
         */
        ONLINING("onlining"),

        /**
         * A starbase that has been attacked and consumed its strontium
         * clathrates to await assistance.
         */
        REINFORCED("reinforced"),

        /**
         * A starbase that is being decommissioned.
         *
         * The starbase can be recovered after finishing its unanchoring cycle.
         */
        UNANCHORING("unanchoring"),

        /**
         * A starbase state that the client cannot recognize.
         */
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, StarbaseState> map = EnumUtil.generateMap(values());

        StarbaseState(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static StarbaseState of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
