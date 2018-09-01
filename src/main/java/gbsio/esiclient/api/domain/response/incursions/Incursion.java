package gbsio.esiclient.api.domain.response.incursions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.incursions.IncursionImpl;

/**
 * Represents data about an active Incursion in the Eve universe.
 */
@JsonDeserialize(as = IncursionImpl.class)
public interface Incursion {
    /**
     * Get the ID of the constellation that the incursion is occupying.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the constellation ID
     * @see gbsio.esiclient.api.domain.response.universe.Constellation
     */
    int getConstellationID();

    /**
     * Get the ID of the faction currently instigating the incursion.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    int getFactionID();

    /**
     * Gets if the boss encounter of this incursion has spawned.
     *
     * @return true if the boss encounter has spawned
     */
    boolean hasBoss();

    /**
     * Get the IDs of the solar systems that are being infested by this
     * incursion.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system IDs
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    ImmutableList<Integer> getInfestedSolarSystems();

    /**
     * Get the percentage of system penalty influence being exerted by this
     * incursion.
     *
     * @return an influence between 0 and 1
     */
    float getInfluence();

    /**
     * Get the ID of the solar system where the incursion is staged.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID of the staging system
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getStagingSolarSystemID();

    /**
     * Get the state of the incursion.
     *
     * @return the state
     */
    State getState();

    /**
     * Get the type of incursion.
     *
     * @return the type
     */
    String getType();

    /**
     * Represents the state of the incursion.
     */
    enum State implements EnumUtil.MappableEnum {
        /** The incursion will be expiring in 24 hours or less. */
        WITHDRAWING("withdrawing"),
        /** The incursion was established 24 hours ago or less. */
        MOBILIZING("mobilizing"),
        /** The incursion has been around for at least 24 hours and will last
         * for at least 24 more hours if it isn't cleared by players. */
        ESTABLISHED("established"),
        /** The state of the incursion could not be determined by the client. */
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, State> map = EnumUtil.generateMap(values());

        State(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static State of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
