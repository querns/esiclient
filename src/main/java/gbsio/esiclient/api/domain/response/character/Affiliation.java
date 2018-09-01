package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.character.AffiliationImpl;

import java.util.Optional;

/**
 * Represents the affiliations a character has, such as corporation or alliance.
 */
@JsonDeserialize(as = AffiliationImpl.class)
public interface Affiliation {
    /**
     * Get the character's ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ID
     * @see CharacterInfo
     */
    int getCharacterID();

    /**
     * Get the ID of the corporation this character belongs to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Get the ID of the alliance this character belongs to, if any.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Get the ID of the faction this character belongs to, if any.
     *
     * A character enrolled in Faction Warfare will have a faction ID
     * corresponding to their enlisted side.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();
}
