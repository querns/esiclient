package gbsio.esiclient.api.domain.response.fleets;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.common.fleets.Role;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.domain.response.fleets.FleetMemberImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents information about other characters in a fleet.
 */
@JsonDeserialize(as = FleetMemberImpl.class)
public interface FleetMember {
    /**
     * Gets the character ID for the character being described.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Get the date that the character joined fleet.
     *
     * @return the join date
     */
    ZonedDateTime getJoinDate();

    /**
     * Get the character's role in the fleet.
     *
     * @return the role
     */
    Role getRole();

    /**
     * Get the localized name for the character's fleet role.
     *
     * @return the localized role name
     */
    String getRoleName();

    /**
     * Get the item type ID of the ship currently being piloted by the player.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ship's item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getShipTypeID();

    /**
     * Get the ID of the solar system the character is currently at.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the solar system ID
     * @see gbsio.esiclient.api.domain.response.universe.SolarSystem
     */
    int getSolarSystemID();

    /**
     * Get the ID of the squad the character currently occupies.
     *
     * @return the squad ID
     */
    Optional<Long> getSquadID();

    /**
     * Get the ID of the station the character is currently docked at, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * Station IDs can refer to structures or NPC stations.
     *
     * @return the ID of the station or structure where the character is docked,
     * or absent if undocked
     */
    Optional<Long> getStationID();

    /**
     * Gets whether the character will accept fleet warps.
     *
     * @return true if the character will take a fleet warp
     */
    boolean willTakeFleetWarp();

    /**
     * Get the ID of the wing the character currently occupies.
     *
     * @return the wing ID
     */
    Optional<Long> getWingID();
}
