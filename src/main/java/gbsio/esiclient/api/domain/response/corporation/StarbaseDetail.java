package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.common.RoleType;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.corporations.FuelImpl;
import gbsio.esiclient.internal.domain.response.corporations.StarbaseDetailImpl;

import java.util.Optional;

/**
 * Represents detailed information about a Player Owned Starbase (POS), including
 * fuel and configuration status.
 */
@JsonDeserialize(as = StarbaseDetailImpl.class)
public interface StarbaseDetail {
    /**
     * Describes if alliance members may enter the force field without the password.
     *
     * @return true if alliance members may enter
     */
    boolean areAllianceMembersAllowed();

    /**
     * Describes if corporation members may enter the force field without the password.
     *
     * @return true if corporation members may enter
     */
    boolean areCorporationMembersAllowed();

    /**
     * Get which party may anchor this starbase.
     *
     * @return the allowed anchoring party
     */
    StarbaseConfigurer getAnchorPermission();

    /**
     * Describes if the starbase's defenses will automatically fire on a highsec
     * war target
     *
     * @return true if the starbase attacks war targets
     */
    boolean willAttackAtWar();

    /**
     * Describes if the starbase's defenses will automatically fire on players
     * whose security status is being reduced due to on-grid criminal activity.
     *
     * @return true if the starbase attacks criminals
     */
    boolean willAttackOnSecurityStatusDrop();

    /**
     * Gets the security status threshold necessary before the starbase
     * automatically opens fire with its defenses.
     *
     * @return the threshold
     */
    Optional<Float> getAttackSecurityStatusThreshold();

    /**
     * Gets the standings threshold necessary before the starbase automatically
     * opens fire with its defenses.
     *
     * @return the threshold
     */
    Optional<Float> getAttackStandingsThreshold();

    /**
     * Describes which party may take from the starbase's fuel bay.
     *
     * @return the party which may take fuel
     */
    StarbaseConfigurer getFuelBayTakePermission();

    /**
     * Described which party may view the inside of the starbase's fuel bay.
     *
     * @return the party which may inspect the fuel bay
     */
    StarbaseConfigurer getFuelBayViewPermission();

    /**
     * Get the fuels currently in the starbase.
     *
     * @return a list of 0 or more fuels
     */
    ImmutableList<Fuel> getFuels();

    /**
     * Describes which party may offline this starbase.
     *
     * @return the party which may offline the starbase
     */
    StarbaseConfigurer getOfflinePermission();

    /**
     * Describes which party may online this starbase.
     *
     * @return the party which may online the starbase
     */
    StarbaseConfigurer getOnlinePermission();

    /**
     * Describes which party may unanchor this starbase.
     *
     * @return the party which may unanchor this starbase
     */
    StarbaseConfigurer getUnanchorPermission();

    /**
     * Describes if the starbase uses alliance standings for making decisions
     * on which targets to fire its defenses upon.
     *
     * @return true if alliance standings are used, false if corporation
     * standings are used
     */
    boolean willUseAllianceStandings();

    /**
     * Describes a party which can perform a task at a starbase.
     */
    enum StarbaseConfigurer implements EnumUtil.MappableEnum {
        /** Any alliance member may perform this task. */
        ALLIANCE_MEMBER("alliance_member"),
        /** Corporation members with the {@link RoleType#CONFIG_STARBASE_EQUIPMENT} role may perform this task. */
        CONFIG_STARBASE_EQUIPMENT_ROLE("config_starbase_equipment_role"),
        /** Any corporation member may perform this task. */
        CORPORATION_MEMBER("corporation_member"),
        /** Corporation members with the {@link RoleType#STARBASE_FUEL_TECHNICIAN} role may perform this task. */
        STARBASE_FUEL_TECHNICIAN_ROLE("starbase_fuel_technician_role"),
        /** A configurer that the client could not understand. */
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, StarbaseConfigurer> map = EnumUtil.generateMap(values());

        StarbaseConfigurer(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static StarbaseConfigurer of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Represents a fuel currently contained in the starbase.
     */
    @JsonDeserialize(as = FuelImpl.class)
    interface Fuel {
        /**
         * Gets the amount of this fuel.
         *
         * @return the amount
         */
        int getQuantity();

        /**
         * Gets the item type ID of this fuel.
         *
         * Only the ID is returned; further discovery will be required for more
         * information and is not in scope for this function call.
         *
         * @return the item type ID
         * @see gbsio.esiclient.api.domain.response.universe.ItemType
         */
        int getItemTypeID();
    }
}
