package gbsio.esiclient.api.domain.response.opportunities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.opportunities.CompletionDataImpl;

import java.time.ZonedDateTime;

/**
 * Represents the dates that a character completed opportunity tasks.
 */
@JsonDeserialize(as = CompletionDataImpl.class)
public interface CompletionData {
    /**
     * Gets the date the character completed this task.
     *
     * @return the completion date
     */
    ZonedDateTime getCompletedDate();

    /**
     * Gets the ID of the task being described by this entry.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the task ID
     * @see OpportunityTask
     */
    int getTaskID();
}
