package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.corporations.OwnedStructureImpl;
import gbsio.esiclient.internal.domain.response.corporations.ServiceImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents a structure owned by a corporation.
 */
@JsonDeserialize(as = OwnedStructureImpl.class)
public interface OwnedStructure {
    /**
     * Gets the corporation ID for this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Gets the date when the structure runs out of fuel.
     *
     * @return the fuel expiry date
     */
    Optional<ZonedDateTime> getFuelExpiryDate();

    /**
     * Gets information describing a change in the structure's reinforcement
     * timer.
     *
     * @return the date of the timer change
     */
    Optional<ReinforcementTimer> getScheduledReinforcementChange();

    /**
     * Gets the ID of the ACL profile governing access to this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * At this time there is no way to acquire information about ACL profiles.
     *
     * @return the ACL profile ID
     */
    int getACLProfileID();

    /**
     * Gets the hour and day that the structure exits its hull and armor
     * reinforce cycle.
     *
     * @return the reinforce timer
     */
    ReinforcementTimer getReinforceTimer();

    /**
     * Gets the structure's services.
     *
     * @return a set containing 0 or more services
     */
    ImmutableList<Service> getServices();

    /**
     * Gets the structure's operational state.
     *
     * @return the operational state
     */
    StructureState getState();

    /**
     * Gets the date that the structure entered its current state.
     *
     * @return the state timer start
     */
    Optional<ZonedDateTime> getStateTimerStart();

    /**
     * Gets the date that the structure exits its current state.
     *
     * @return the end state timer
     */
    Optional<ZonedDateTime> getStateTimerEnd();

    /**
     * Returns the unique item ID for this structure.
     *
     * @return the ID
     */
    long getID();

    /**
     * Gets the ID of the item type describing this structure.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getItemTypeID();

    /**
     * Gets the ID of the solar system where this structure is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the date that the structure finishes its unanchoring routine.
     *
     * @return the unanchor date
     */
    Optional<ZonedDateTime> getUnanchorDate();

    /**
     * Represents a reinforcement timer of the structure.
     */
    interface ReinforcementTimer {
        /**
         * Gets the date when the change to reinforce timer takes effect, if
         * applicable.
         *
         * @return the date
         */
        Optional<ZonedDateTime> getDate();

        /**
         * Gets the hour that the structure's reinforce timer will change to.
         *
         * @return an hour between 0 and 23
         */
        int getHour();

        /**
         * Gets the day of the week that the structure's reinforce timer will
         * change to.
         *
         * @return a day of the week between 0 (Sunday) and 6 (Saturday)
         */
        int getWeekday();
    }

    /**
     * Represent a structure service.
     */
    @JsonDeserialize(as = ServiceImpl.class)
    interface Service {
        /**
         * Get the name of the service.
         *
         * @return the service name
         */
        String getName();

        /**
         * Get the service's status.
         *
         * @return the service status
         */
        ServiceStatus getStatus();
    }

    /**
     * Describes what status a structure service is running as.
     */
    enum ServiceStatus implements EnumUtil.MappableEnum {
        ONLINE("online"), OFFLINE("offline"), CLEANUP("cleanup"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, ServiceStatus> map = EnumUtil.generateMap(values());

        ServiceStatus(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static ServiceStatus of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Describes the operational state of a structure.
     */
    enum StructureState implements EnumUtil.MappableEnum {
        ANCHOR_VULNERABLE("anchor_vulnerable"), ANCHORING("anchoring"),
        ARMOR_REINFORCE("armor_reinforce"), ARMOR_VULNERABLE("armor_vulnerable"),
        FITTING_INVULNERABLE("fitting_invulnerable"), HULL_REINFORCE("hull_reinforce"),
        HULL_VULNERABLE("hull_vulnerable"), ONLINE_DEPRECATED("online_deprecated"),
        ONLINING_VULNERABLE("onlining_vulnerable"), SHIELD_VULNERABLE("shield_vulnerable"),
        UNANCHORED("unanchored"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, StructureState> map = EnumUtil.generateMap(values());

        StructureState(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static StructureState of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
