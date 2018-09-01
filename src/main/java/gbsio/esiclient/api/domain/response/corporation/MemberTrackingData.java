package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.corporations.MemberTrackingDataImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents tracking data on corporation members.
 */
@JsonDeserialize(as = MemberTrackingDataImpl.class)
public interface MemberTrackingData {
    /**
     * Gets the ID of the the character's home station or structure
     *
     * @return a station or structure ID corresponding to the character's home
     */
    Optional<Integer> getBaseID();

    /**
     * Get the ID of the character this data is for.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     */
    int getCharacterID();

    /**
     * Get the ID of the character's current location.
     *
     * @return the ID of the station, structure, or solar system the character
     * is at
     */
    Optional<Long> getLocationID();

    /**
     * Get the date of the character's last logoff.
     *
     * @return the logoff date
     */
    Optional<ZonedDateTime> getLogoffDate();

    /**
     * Get the date of the character's last login.
     *
     * @return the login date
     */
    Optional<ZonedDateTime> getLoginDate();

    /**
     * Get the item type ID of the character's active ship.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the item type ID of the character's active ship
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    Optional<Integer> getShipTypeID();

    /**
     * Get the date the character joined the corporation.
     *
     * @return the join date
     */
    Optional<ZonedDateTime> getStartDate();
}
