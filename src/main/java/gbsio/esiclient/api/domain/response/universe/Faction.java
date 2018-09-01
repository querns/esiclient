package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.universe.FactionImpl;

import java.util.Optional;

/**
 * Represents an NPC faction.
 */
@JsonDeserialize(as = FactionImpl.class)
public interface Faction {
    /**
     * Gets an ID of the primary corporation associated with this faction.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    Optional<Integer> getCorporationID();

    /**
     * Gets the description of this faction.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the unique ID for this faction.
     *
     * @return the ID
     */
    int getID();

    /**
     * Gets whether the faction is unique.
     *
     * @return true if the faction is unique
     */
    boolean isUnique();

    /**
     * Gets the ID of the corporation representing this faction's FW militia
     * corporation.
     *
     * @return the militia's corporation ID
     */
    Optional<Integer> getMilitiaCorporationID();

    /**
     * Gets the name of the faction.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the size factor of this faction.
     *
     * @return the size factor
     */
    float getSizeFactor();

    /**
     * Gets the ID of the primary solar system associated with this faction.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the primary solar system ID
     * @see SolarSystem
     */
    Optional<Integer> getSolarSystemID();

    /**
     * Gets the number of stations controlled by this faction.
     *
     * @return the station count
     */
    int getStationCount();

    /**
     * Gets the number of solar systems containing at least one station
     * belonging to this faction.
     *
     * @return the station system count
     */
    int getStationSystemCount();
}
