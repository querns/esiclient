package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.corporations.AllianceHistoryImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an entry in a corporation's alliance history.
 */
@JsonDeserialize(as = AllianceHistoryImpl.class)
public interface AllianceHistory {
    /**
     * Gets the ID of the alliance in this history entry.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the alliance ID
     * @see gbsio.esiclient.api.domain.response.alliance.AllianceInfo
     */
    Optional<Integer> getAllianceID();

    /**
     * Get whether the alliance in this history entry has since been deleted.
     *
     * @return true if the alliance has been deleted
     */
    Optional<Boolean> isDeleted();

    /**
     * Get the record ID for this entry.
     *
     * Record IDs are an incrementing ID that can be used to canonically
     * establish the order of records in the case that dates are ambiguous.
     *
     * @return the record ID
     */
    int getRecordID();

    /**
     * Gets the date the corporation became a member of the alliance in question.
     *
     * @return the join date
     */
    ZonedDateTime getStartDate();
}
