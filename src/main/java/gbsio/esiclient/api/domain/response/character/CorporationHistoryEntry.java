package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.corporation.CorporationInfo;
import gbsio.esiclient.internal.domain.response.character.CorporationHistoryEntryImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an item in a character's corporation history.
 */
@JsonDeserialize(as = CorporationHistoryEntryImpl.class)
public interface CorporationHistoryEntry {
    /**
     * Gets the corporation ID.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the corporation ID
     * @see CorporationInfo
     */
    int getCorporationID();

    /**
     * Get the record ID for this history entry.
     *
     * Record IDs are used to determine the history entry's sorting order.
     *
     * @return the record ID
     */
    int getRecordID();

    /**
     * Get the date that the character joined this corporation.
     *
     * @return the start date
     */
    ZonedDateTime getStartDate();

    /**
     * Get whether the corporation in question has since been deleted.
     *
     * @return true if the corporation was deleted
     */
    Optional<Boolean> isDeleted();
}
