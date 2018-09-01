package gbsio.esiclient.api.domain.response.killmails;

import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;

import java.util.Optional;

/**
 * Represents information shared by both attacker and victim.
 */
public interface Participant {
    /**
     * Gets the ID of the alliance of the participant.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID, or absent if the participant isn't in an
     * alliance or is a non-character entity
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Gets the character ID of the participant.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID, or absent if the participant is not a character
     * @see CharacterInfo
     */
    Optional<Integer> getCharacterID();

    /**
     * Gets the ID of the corporation the participant belongs to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID, or absent if the participant is a
     * non-character entity
     * @see CorporationInfo
     */
    Optional<Integer> getCorporationID();

    /**
     * Gets the ID of the faction that the participant belongs to.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the faction ID, or absent if the participant is a non-character
     * entity or the entity is not in faction warfare
     * @see gbsio.esiclient.api.domain.response.universe.Faction
     */
    Optional<Integer> getFactionID();

    /**
     * Gets the item type ID of the ship the participant was piloting when the
     * attack occurred.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ship's item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    Optional<Integer> getShipItemTypeID();
}
