package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import gbsio.esiclient.api.domain.response.common.CelestialObject;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.universe.StationImpl;

import java.util.Optional;

/**
 * Represents an NPC station in New Eden.
 */
@JsonDeserialize(as = StationImpl.class)
public interface Station extends CelestialObject {
    /**
     * Gets the maximum volume that any one ship may possess and dock at this
     * station.
     *
     * @return the max volume allowed for docking
     */
    float getMaxDockableShipVolume();

    /**
     * Gets the rental cost for an office at this station.
     *
     * @return the rental cost
     */
    float getOfficeRentalCost();

    /**
     * Gets the ID of the corporation that owns this station.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the owner's corporation ID
     * @see CorporationInfo
     */
    Optional<Integer> getOwnerCorporationID();

    /**
     * Gets the ID of the race associated with this station, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the race ID
     * @see Race
     */
    Optional<Integer> getRaceID();

    /**
     * Gets the base reprocessing efficiency of this station.
     *
     * @return the reprocessing efficiency
     */
    float getReprocessingEfficiency();

    /**
     * Gets the amount of materials that this station takes as payment when
     * reprocessing materials.
     *
     * @return the reprocessing take
     */
    float getReprocessingTake();

    /**
     * Gets a list of services performed at this station.
     *
     * @return 1 or more services
     */
    ImmutableSet<Service> getServices();

    /**
     * Gets the unique ID for this station.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets the ID of the solar system where this station is located.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see SolarSystem
     */
    int getSolarSystemID();

    /**
     * Gets the ID of the item type describing this station.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID
     * @see ItemType
     */
    int getItemTypeID();

    /**
     * Describes a service available at a station.
     */
    enum Service implements EnumUtil.MappableEnum {
        BOUNTY_MISSIONS("bounty-missions"),
        ASSASSINATION_MISSIONS("assasination-missions"),
        COURIER_MISSIONS("courier-missions"), INTERBUS("interbus"),
        REPROCESSING_PLANT("reprocessing-plant"), REFINERY("refinery"),
        MARKET("market"), BLACK_MARKET("black-market"),
        STOCK_EXCHANGE("stock-exchange"), CLONING("cloning"),
        SURGERY("surgery"), DNA_THERAPY("dna-therapy"),
        REPAIR_FACILITIES("repair-facilities"), FACTORY("factory"),
        LABORATORY("labratory"), GAMBLING("gambling"), FITTING("fitting"),
        PAINTSHOP("paintshop"), NEWS("news"), STORAGE("storage"),
        INSURANCE("insurance"), DOCKING("docking"),
        OFFICE_RENTAL("office-rental"),
        JUMP_CLONE_FACILITY("jump-clone-facility"),
        LOYALTY_POINT_STORE("loyalty-point-store"),
        NAVY_OFFICES("navy-offices"),
        SECURITY_OFFICES("security-offices"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Service> map = EnumUtil.generateMap(values());

        Service(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Service of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
