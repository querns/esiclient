package gbsio.esiclient.api.domain.response.alliance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.alliance.AllianceInfoImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents public information about an alliance.
 */
@JsonDeserialize(as=AllianceInfoImpl.class)
public interface AllianceInfo {
    /**
     * Gets the ID of the corporation originally responsible for founding this
     * alliance.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID of the creator
     * @see CorporationInfo
     */
    int getCreatorCorporationID();

    /**
     * Gets the ID of the character originally responsible for founding this
     * alliance.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the creator
     * @see CharacterInfo
     */
    int getCreatorCharacterID();

    /**
     * Gets the date the alliance was created.
     *
     * @return the creation date
     */
    ZonedDateTime getCreationDate();

    /**
     * Gets the ID of the corporation currently controlling the alliance.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the executor's corporation ID
     * @see CorporationInfo
     */
    Optional<Integer> getExecutorCorpID();

    /**
     * Gets the ID of the faction this alliance belongs to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();

    /**
     * Gets the name of the alliance.
     *
     * @return the alliance name
     */
    String getName();

    /**
     * Gets the ticker of the alliance.
     *
     * @return a ticker, up to five characters
     */
    String getTicker();
}
