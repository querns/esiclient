package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.internal.domain.response.corporations.CorporationInfoImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents the public information of an EVE corporation.
 */
@JsonDeserialize(as = CorporationInfoImpl.class)
public interface CorporationInfo {
    /**
     * Gets the ID of the alliance the corporation belongs to, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Gets the character ID of the current CEO of the corporation.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the CEO
     * @see CharacterInfo
     */
    int getCeoID();

    /**
     * Gets the character ID of the original creator of the corporation.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the original corp creator
     * @see CharacterInfo
     */
    int getCreatorID();

    /**
     * Gets the founding date of the corporation.
     *
     * @return the founding date
     */
    Optional<ZonedDateTime> getFoundingDate();

    /**
     * Get the corporation's user-created description.
     *
     * @return the description
     */
    Optional<String> getDescription();

    /**
     * Gets the faction ID for the corporation.
     *
     * A corporation enrolled in faction warfare will have a faction ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();

    /**
     * Get the home station ID for this corporation.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the home station ID
     */
    Optional<Integer> getHomeStationID();

    /**
     * Get the member count of the corporation.
     *
     * @return the member count
     */
    int getMemberCount();

    /**
     * Get the corporation's name.
     *
     * @return the name
     */
    String getName();

    /**
     * Get how many shares of corporation stock have been issued.
     *
     * @return the share quantity
     */
    Optional<Integer> getShares();

    /**
     * Get the corporation's tax rate.
     *
     * @return a number between 0 and 1
     */
    float getTaxRate();

    /**
     * Gets the corporation's ticker.
     *
     * A ticker is a short string up to five characters that acts as short name
     * for a corporation.
     *
     * @return the ticker
     */
    String getTicker();

    /**
     * Get the user-supplied URL associated with the corporation.
     *
     * @return the corporation's URL
     */
    Optional<String> getURL();

    /**
     * Get the war eligibility status of the corporation.
     *
     * @return is the corporation war eligible
     */

    Optional<Boolean> isWarEligible();
}
