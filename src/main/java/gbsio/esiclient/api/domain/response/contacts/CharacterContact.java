package gbsio.esiclient.api.domain.response.contacts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.contacts.CharacterContactImpl;

import java.util.Optional;

/**
 * Represents a contact set by a character.
 */
@JsonDeserialize(as = CharacterContactImpl.class)
public interface CharacterContact extends BaseContact, WatchlistableContact {
    /**
     * Returns whether or not the contact for this character is blocked.
     *
     * @return true if the contact is blocked, false if it isn't, and missing if
     * the block status is unknown
     */
    Optional<Boolean> isBlocked();

}
